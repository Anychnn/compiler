package stmt;

import inter.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 */
public class ArrayExpr extends Expr {
    List<Expr> exprList;
    public ArrayExpr(List<Expr> exprList, Type type) {
        super(new Word("[]", Tag.Array),type);
        this.exprList=exprList;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<exprList.size();i++){
            if(i!=0){
                sb.append(",");
            }
            sb.append(exprList.get(i).toString());
        }
        return "["+sb.toString()+"]";
    }
}
