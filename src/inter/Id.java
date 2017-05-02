package inter;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Id extends Expr{
    public int offset;
    public Word word;
    public Id(Word id,Type p,int offset) {
        super(id,null);
        this.offset = offset;
        this.word=id;
        this.type=p;
    }

    @Override
    public String toString() {
        return word.value;
    }
}
