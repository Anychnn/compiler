package inter;

/**
 * Created by Administrator on 2017/5/1.
 */
public class Constant extends Expr {
    private Token tok;
    public Constant(Token op, Type type) {
        super(op, type);
        this.tok=op;
        this.type=type;
    }
    public static final Constant
        True=new Constant(Word.True,Type.Bool),
        False=new Constant(Word.False,Type.Bool);

    public String toString() {
        return tok.toString();
    }
}

