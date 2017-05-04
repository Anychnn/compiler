package stmt;

import inter.Tag;
import inter.Type;

/**
 * Created by Administrator on 2017/5/3.
 */
public class Array extends Type {
    public int size;
    public Type of;
    public Array(int sz,Type p) {
        super("[]", Tag.Index, sz*p.width);
        this.of=p;
        this.size=sz;
    }


}
