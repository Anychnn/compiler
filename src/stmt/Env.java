package stmt;

import inter.Id;
import inter.Token;

import java.util.Hashtable;

/**
 * Created by Administrator on 2017/4/30.
 */
public class Env {
    protected Env prev;
    private Hashtable table;
    public Env(Env prev) {
        this.prev = prev;
        this.table=new Hashtable();
    }

    public void put(Token tok, Id id){
        table.put(tok,id);
    }
    public Id get(Token tok){
        for(Env env=this;env!=null;env=env.prev){
            Id id= (Id) env.table.get(tok);
            if(id!=null){
                return id;
            }
        }
        return null;
    }
}
