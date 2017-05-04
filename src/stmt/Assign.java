package stmt;

import expr.Access;
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
        if(reference.type instanceof Array&&value.type instanceof Array){
            Array referenceArrayType= (Array) reference.type;
            Array valueArrayType= (Array) value.type;
            if(referenceArrayType.of!=valueArrayType.of){
                error("type error: assign "+valueArrayType.of+" to "+referenceArrayType.of);
            }else {
                return;
            }
        }
        if(!this.reference.type.equals(value.type)){
            error("type error: assign "+value.type+" to "+reference.type);
        }
    }

    @Override
    public void gen(int b, int a) {
        if(!hasLabel){
            int label=newlabel();
            emitlabel(label);
            hasLabel=true;
        }
        emit(reference.word.value + " = " + value.reduce());
        hasLabel=false;
    }
}
