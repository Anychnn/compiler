package inter;

/**
 * Created by Administrator on 2017/5/2.
 */
public class Real extends Token {
    public float value;
    public Real(float v) {
        super(Tag.Real);
        this.value=v;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
