package expr;

import inter.*;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Access extends Expr {

    public Id reference;
    public Expr index;
    public Access(Id reference, Expr index,Type type) {
        super(new Word("[]",Tag.Index), type);
        this.index=index;
        this.reference=reference;
    }

    @Override
    public String toString() {
//        return reference+"["+index+"]";
        return reference.toString()+"["+index.toString()+"]";
    }
}
