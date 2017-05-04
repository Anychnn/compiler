package stmt;

import inter.Expr;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Do extends Stmt {
    private Expr expr;
    private Stmt stmt;

    public Do(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
    }

    @Override
    public void gen(int b, int a) {
        Expr temp=expr.reduce();
        int label=newlabel();
        emitlabel(label);
        hasLabel=true;
        stmt.gen(b,a);
        int label2=newlabel();
        emitlabel(label2);
        hasLabel=true;
        emit("if "+temp+" goto L"+label);
        hasLabel=false;
    }
}
