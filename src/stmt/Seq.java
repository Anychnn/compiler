package stmt;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Seq extends Stmt {
    private Stmt stmt1;
    private Stmt stmt2;

    public Seq(Stmt stmt1, Stmt stmt2) {
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    @Override
    public void gen(int b, int a) {
        stmt1.gen(b,a);
        stmt2.gen(b,a);
    }
}
