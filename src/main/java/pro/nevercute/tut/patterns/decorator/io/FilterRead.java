package pro.nevercute.tut.patterns.decorator.io;

import java.io.*;

public class FilterRead {
    public static void main(String[] args) {
        int c;
        try{
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream(new File("C:\\work_space\\E8L5HXTNOO.txt") )));
            InputStreamReader ir = new InputStreamReader(in, "UTF-8");
            while ((c = ir.read()) >= 0){
                System.out.print(c);
            }
            in.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
