package stmt;

import inter.Expr;

/**
 * Created by Administrator on 2017/5/1.
 */
public class While extends Stmt {
    private Expr expr;
    private Stmt stmt;

    public While(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
    }

    @Override
    public void gen(int b, int a) {

        int label1=newlabel();
        emitlabel(label1);
        emit("iffalse "+expr.reduce()+" goto L"+a);
        stmt.gen(b,a);
        emit("goto L"+label1);
    }

}
