package stmt;

import inter.Expr;
import stmt.Stmt;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Else extends Stmt {
    private Stmt stmt1;
    private Stmt stmt2;
    private Expr expr;

    public Else(Expr expr,Stmt stmt1, Stmt stmt2) {
        this.expr=expr;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    @Override
    public void gen(int b, int a) {
        int lable1=newlabel();
        int label2=newlabel();
        emit("iffalse "+expr+" goto L"+label2);
        emitlabel(lable1);
        stmt1.gen(b,a);
        emit("goto L"+a);
        emitlabel(label2);
        stmt2.gen(b,a);
//        System.out.println(""+lable1);
    }
}
