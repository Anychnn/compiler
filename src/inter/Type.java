package inter;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Type extends Word {
    public int width=0;
    public Type(String s, int tag,int width) {
        super(s,tag);
        this.width=width;
    }
    public static final Type
        Int=new Type("int",Tag.Basic,4),
        Float=new Type("float",Tag.Basic,8),
        Char=new Type("char",Tag.Basic,1),
        Bool=new Type("bool",Tag.Basic,1);
}
