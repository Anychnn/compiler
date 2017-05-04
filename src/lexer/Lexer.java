package lexer;

import inter.*;

import java.io.*;
import java.util.Hashtable;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Lexer {
    //Lexer的状态
    enum State{
        Normal,Anotation,Regex
    }
    private String path;
    int index=0;
    private char peek;
    private StringBuffer buffer =new StringBuffer();
    private Hashtable words=new Hashtable();
    public static int line=1;
    private State state=State.Normal;
    public Lexer(String path) {
        this.path=path;
        init();
    }
    public void reserve(Word word){
        words.put(word.value,word);
    }
    public void init(){
        reserve(new Word("if", Tag.If));
        reserve(new Word("else", Tag.Else));
        reserve(new Word("while", Tag.While));
        reserve(new Word("break",Tag.Break));
        reserve(new Word("do",Tag.Do));
        reserve(Type.Int);
        reserve(Type.Float);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Word.True);
        reserve(Word.False);

        File file=new File(path);
        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line=null;
            while ((line=reader.readLine())!=null){
                buffer.append(line+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        read();
        System.out.println(buffer);
    }
    public char read(){
        if(index== buffer.length()-1){
            peek='\u0000';
        }else{
            peek= buffer.charAt(index);
            index++;
        }
        return peek;
    }

    public boolean isEnd(){
        return index== buffer.length();
    }


    /**
     * 返回null代表没有拿到想要的token  需要继续读
     * @return
     */
    public Token move(){
        if (state==State.Normal){
            while (peek=='\n'||peek==' '||peek=='\t'){
                if(peek=='\n'){
                    line++;
                }
                read();
            }
            if(Character.isDigit(peek)){
                int v=0;
                do{
                    v=10*v+Character.digit(peek,10);
                    read();
                }while (Character.isDigit(peek));
                if(peek!='.'){
                    return new Num(v);
                }
                read();
                float x=v;
                float d=10;
                do{
                    x+=Character.digit(peek,10)/d;
                    d*=10;
                    read();
                }while (Character.isDigit(peek));
                return new Real(x);
            }else if(Character.isLetter(peek)){
                StringBuffer sb=new StringBuffer();
                do{
                    sb.append(peek);
                    read();
                }while (Character.isLetter(peek));
                Word word=null;
                word= (Word) words.get(sb.toString());
                if(word==null){
                    word=new Word(sb.toString(),Tag.ID);
                    words.put(sb.toString(),word);
                }
                return word;
            }
            if(peek=='\u0000') return new Token(Tag.End);
            if(peek=='/'){
                read();
                if(peek=='/'){
                    read();
                    state=state.Anotation;
                }
                return null;
            }
            Token tok=new Token(peek);
            read();
            return tok;
//        }else if(state==State.Anotation){
        }else{
            StringBuffer sb=new StringBuffer();
            while (peek!='\n'){
                sb.append(peek);
                read();
            }
            state=State.Normal;
            System.out.println("read Anotation:"+sb.toString());
            return null;
        }
    }
}
