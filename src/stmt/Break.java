package stmt;

/**
 * Created by Administrator on 2017/5/1.
 */
public class Break extends Stmt {
    @Override
    public void gen(int b, int a) {
        if(!hasLabel){
            int label=newlabel();
            emitlabel(label);
        }
        emit("goto L"+a);
        hasLabel=false;
    }
}
