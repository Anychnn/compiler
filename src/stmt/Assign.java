package stmt;

import inter.Expr;
import inter.Id;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Assign extends Stmt {
    private Id reference;
    private Expr value;

    public Assign(Id reference, Expr value) {
        this.reference = reference;
        this.value = value;
        check();
    }

    public void check(){
        if(!this.reference.type.equals(value.type)){
            error("type error: assign "+value.type+" to "+reference.type);
        }
    }

    @Override
    public void gen(int b, int a) {
        emit(reference.word.value + " = " + value.reduce());
    }
}
