package stmt;

import inter.Expr;
import inter.Token;
import inter.Type;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Unary extends Expr {
    private Token op;
    private Expr expr;
    public Unary(Token op,Expr expr) {
        super(op, null);
        this.op=op;
        this.expr=expr;
        this.type=expr.type;
    }

    @Override
    public String toString() {
        return "-"+expr;
    }
}
