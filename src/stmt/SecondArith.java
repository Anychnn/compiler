package stmt;

import inter.Expr;
import inter.Token;

/**
 * Created by Administrator on 2017/4/30.
 */
public class SecondArith extends Expr {
    public SecondArith(Token lookahead, Expr expr, Expr factor) {
        super(lookahead, null);
    }
}
