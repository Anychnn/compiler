package stmt;

import expr.Access;
import inter.Expr;
import inter.Id;

import java.util.Set;

/**
 * Created by Administrator on 2017/5/3.
 */
public class SetElem extends Stmt {
    public Id array;
    public Expr index;
    public Expr expr;
    public SetElem(Access x, Expr e){
        array=x.reference;
        this.expr=e;
        this.index=x.index;
    }

    @Override
    public void gen(int b, int a) {
        String s1=index.op.toString();
        emit(array.toString()+"["+s1+"]"+"="+expr.toString());
    }
}
