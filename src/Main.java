import lexer.Lexer;

import java.io.File;

/**
 * Created by Administrator on 2017/4/29.
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        File[] files=new File("resources").listFiles();
//        for(File file:files){
//            String fileName=file.getName();
//            if(fileName.endsWith("compiler")) {
//                Lexer lexer=new Lexer(file.getPath());
//                Parser parser=new Parser(lexer);
//                parser.parse();
//                System.out.println();
//                System.out.println("--------------------------------------");
//            }
//        }

        Lexer lexer=new Lexer("resources/test5.compiler");
        Parser parser=new Parser(lexer);
        parser.parse();
        System.out.println();
    }
}
