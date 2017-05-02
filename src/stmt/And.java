package stmt;

import inter.Expr;
import inter.Token;
import inter.Type;

/**
 * Created by Administrator on 2017/4/30.
 */
public class And extends Expr {
    public And(Token lookahead, Expr expr, Expr and) {
        super(lookahead, Type.Bool);
    }
}
