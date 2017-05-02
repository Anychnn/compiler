package stmt;

import inter.Expr;
import stmt.Stmt;

/**
 * Created by Administrator on 2017/4/29.
 */
public class If extends Stmt {
    private Stmt stmt;
    private Expr bool;

    public If(Expr bool,Stmt stmt) {
        this.stmt = stmt;
        this.bool=bool;
    }

    @Override
    public void gen(int b, int a) {
        int label=newlabel();
        emit("iffalse "+bool+" goto L"+a);
        emitlabel(label);
        stmt.gen(b,a);
    }
}
