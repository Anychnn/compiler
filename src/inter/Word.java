package inter;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Word extends Token{
    public String value;
    public Word(String value,int tag) {
        super(tag);
        this.value=value;
    }

    public static final Word
        temp=new Word("t",Tag.Temp),minus=new Word("minus",Tag.Minus),
        True=new Word("true",Tag.TRUE),False=new Word("false",Tag.FALSE);



    @Override
    public String toString() {
        return value;
    }
}
