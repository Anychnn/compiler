package inter;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Temp extends Expr {
    public static int count=0;
    private int number=0;
    public Temp(Type type) {
        super(Word.temp, type);
        number=++count;
    }

    @Override
    public String toString() {
        return "temp"+number;
    }
}
