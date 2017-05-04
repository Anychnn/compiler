package inter;

/**
 * Created by Administrator on 2017/5/1.
 */
public class Constant extends Expr {
    public Constant(Token op, Type type) {
        super(op, type);
        this.type=type;
    }
    public Constant(int i){
        super(new Num(i),Type.Int);
    }
    public static final Constant
        True=new Constant(Word.True,Type.Bool),
        False=new Constant(Word.False,Type.Bool);


    @Override
    public String toString() {
        return op.toString();
    }
}

