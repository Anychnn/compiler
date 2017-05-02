package stmt;

import inter.Expr;
import inter.Token;
import inter.Type;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Or extends Expr {

    public Or(Token lookahead, Expr expr, Expr or) {
        super(lookahead,Type.Bool);
    }
}
