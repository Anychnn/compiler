import inter.*;
import stmt.*;
import lexer.Lexer;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Parser {
    private Lexer lexer;
    private Token lookahead;
    private Env top;
    int used=0;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        move();
    }
    public void error(String msg) throws Exception {
        throw new Exception(msg+":"+lookahead);
    }
    public void move(){
        lookahead=lexer.move();
    }
    public void match(int tag) throws Exception {
        if(lookahead.tag!=tag){
            error("syntax error");
        }
        move();
    }
    public void parse() throws Exception {
        Stmt stmt=block();
        match(';');
        match(Tag.End);

        int label1=stmt.newlabel();
        int label2=stmt.newlabel();
        stmt.emitlabel(label1);
        stmt.gen(label1,label2);
        stmt.emitlabel(label2);
    }
    public Stmt block() throws Exception {
        match('{');
        Env saved=top;
        top=new Env(saved);
        decls();
        Stmt stmt=stmts();
        match('}');
        top=saved;
        return stmt;
    }
    public Stmt stmts() throws Exception {
        if(lookahead.tag=='}')  return Stmt.Null;
        else if(lookahead.tag=='{'){
            match('{');
            Env saved=top;
            top=new Env(saved);
            Stmt stmt=stmts();
            match('}');
            top=saved;
            return stmt;
        }
        else return new Seq(stmt(),stmts());
    }

    public Stmt stmt() throws Exception {
        switch (lookahead.tag){
            case ';':
                match(';');
                return Stmt.Null;
            case Tag.If:
                match(Tag.If);
                match('(');
                Expr expr1=bool();
                match(')');
                Stmt stmt1=null;
                if(lookahead.tag=='{'){
                    stmt1=stmts();
                }else{
                    stmt1=stmt();
                }
                if(lookahead.tag==Tag.Else){
                    match(Tag.Else);
                    Stmt stmt2=null;
                    if(lookahead.tag=='{'){
                        stmt2=stmts();
                    }else {
                        stmt2=stmt();
                    }
                    return new Else(expr1,stmt1,stmt2);
                }
                return new If(expr1,stmt1);
            case Tag.While:
                match(Tag.While);
                match('(');
                Expr expr2=bool();
                match(')');
                Stmt stmt=stmts();
                return new While(expr2,stmt);
            case Tag.Break:
                match(Tag.Break);
                match(';');
                return new Break();
            case Tag.Do:
                match(Tag.Do);
                match('{');
                Stmt stmt2=stmts();
                match('}');
                match(Tag.While);
                match('(');
                Expr expr=bool();
                match(')');
                match(';');
                return new Do(expr,stmt2);
            default:
                return assign();
        }
    }

    public Stmt assign() throws Exception {
        Id reference=top.get(lookahead);
        if(reference==null){
            error(((Word)lookahead).value+"  is not defined at line:"+lexer.line);
        }
        match(Tag.ID);
        match('=');
        Expr assign=bool();
        match(';');
        return new Assign(reference,assign);
    }
    public Expr bool() throws Exception {
        Expr expr=or();
        if(lookahead.tag=='|'){
            match('|');
            expr=new Or(lookahead,expr,or());
        }
        return expr;
    }

    public Expr or() throws Exception {
        Expr expr=and();
        if(lookahead.tag=='&'){
            match('&');
            expr=new And(lookahead,expr,and());
        }
        return expr;
    }
    public Expr and() throws Exception {
        Expr expr=rel();
        return expr;
    }
    public Expr rel() throws Exception {
        Expr expr=expr();
        switch (lookahead.tag){
            case '<':
                Token tok1=lookahead;
                match('<');
                return new Rel(tok1,expr,expr());
            case '>':
                Token tok2=lookahead;
                match('>');
                return new Rel(tok2,expr,expr());
        }
        return expr;
    }

    public Expr expr() throws Exception {
        Expr expr=term();
        if(lookahead.tag=='+'){
            Token tok=lookahead;
            match('+');
            expr=new FirstArith(tok,expr,term());
        }else if(lookahead.tag=='-'){
            Token tok=lookahead;
            match('-');
            expr=new FirstArith(tok,expr,term());
        }
        return expr;
    }
    public Expr term() throws Exception {
        Expr expr=unary();
        if(lookahead.tag=='*'){
            match('*');
            expr=new SecondArith(lookahead,expr,unary());
        }else if(lookahead.tag=='/'){
            match('/');
            expr=new SecondArith(lookahead,expr,unary());
        }
        return expr;
    }
    public Expr unary() throws Exception {
        if(lookahead.tag=='-'){
            match('-');
            return new Unary(Word.minus,factor());
        }else if(lookahead.tag=='!'){
            return null;
        }else{
            return factor();
        }
    }
    public Expr factor() throws Exception {
        Expr x=null;
        switch (lookahead.tag){
            case Tag.ID:
                x=top.get(lookahead);
                match(Tag.ID);
                return x;
            case Tag.FALSE:
                match(Tag.FALSE);
                return Constant.False;
            case Tag.TRUE:
                match(Tag.TRUE);
                return Constant.True;
            case Tag.Real:
                Token tok=lookahead;
                match(Tag.Real);
                x=new Constant(tok,Type.Float);
                return x;
        }
        return null;
    }
    public void decls() throws Exception {
        Type p=type();
        Token tok=lookahead;
        match(Tag.ID);
        match(';');
        top.put(tok,new Id((Word) tok,p,used));
        used+=p.width;
        while (lookahead.tag==Tag.Basic){
            decls();
        }
    }
    public Type type() throws Exception {
        Type p= (Type) lookahead;
        match(Tag.Basic);
        return p;
    }
}
