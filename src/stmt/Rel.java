package stmt;

import inter.Expr;
import inter.Token;
import inter.Type;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Rel extends Expr {
    private Token tok;
    Expr expr1,expr2;
    public Rel(Token tok, Expr expr1, Expr expr2) {
        super(tok, Type.Bool);
        this.expr1=expr1;
        this.expr2=expr2;
        this.tok=tok;
    }

    @Override
    public String toString() {
        char ch= (char) tok.tag;
        Expr a=expr1.reduce();
        Expr b=expr2.reduce();
        return a.toString()+" "+ ch+" "+b.toString();
    }
}
