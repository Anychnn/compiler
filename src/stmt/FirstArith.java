package stmt;

import inter.Expr;
import inter.Temp;
import inter.Token;

/**
 * Created by Administrator on 2017/4/30.
 */
public class FirstArith extends Expr {

    private Expr expr1,expr2;
    private Token tok;
    public FirstArith(Token lookahead, Expr expr1, Expr expr2) {
        super(lookahead, expr1.type);
        this.expr1=expr1;
        this.expr2=expr2;
        tok=lookahead;
    }

    public Expr reduce(){
        Temp temp=new Temp(type);
        emit(temp.toString()+" = "+this.toString());
        return temp;
    }

    @Override
    public String toString() {
        char ch= (char) tok.tag;
        return expr1.toString()+" "+ch+" "+expr2.toString();
    }
}
