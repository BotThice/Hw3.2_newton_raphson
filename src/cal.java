import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class cal {
    public static void main(String[] args) {
        Double es = 0.00001,fx=1.0,init=1.0,fxx=1.0,x=init;
        Integer i=0;
        File file = new File("src/value3_2.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String s ;
            while(Math.abs(fx) >= es){
                s = 'x'+i.toString()+": "+x.toString();
                fx = Math.pow(Math.E,-x)-x;
                fxx = -Math.pow(Math.E,-x)-1;
                x = x-(fx/fxx);
                s = s+" fx: "+fx.toString()+" fxx: "+fxx.toString();
                writer.write(s+"\n");
                i++;
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
