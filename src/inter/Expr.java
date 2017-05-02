package inter;

import stmt.Node;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Expr extends Node {
    public Token op;
    public Type type;

    public Expr(Token op, Type type) {
        this.op = op;
        this.type = type;
    }


    public Expr reduce(){
        return this;
    }
}
