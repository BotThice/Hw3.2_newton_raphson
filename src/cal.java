import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class cal {
    public static void main(String[] args) {
        Double es = 0.00001,fx=1.0,init=1.0,fxx=1.0,x=init;
        Integer i=0,subProb=4;
        File file = new File("src/value3_"+subProb.toString()+".txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String s ;
            while(Math.abs(fx) >= es){
                s = 'x'+i.toString()+": "+x.toString();
                fx = cal1_3fx(x,subProb);
                fxx = cal1_3fxx(x,subProb);
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
    public static Double cal1_3fxx(Double x,int subProb){ //1_3 mean subproblem 1-3
        switch (subProb) {
            case 4:
                return (3*Math.pow(x,2))+(4*x)+1;
            case 3:
                return 3 * Math.pow(x, 2);
            case 2:
                return -Math.pow(Math.E, -x) - 1;
            case 1:
                return (3*Math.pow(x,2))-1;
            default:
                System.err.println("Wrong subproblem input");
                return Double.NaN;
        }

    }
    public static Double cal1_3fx(Double x,int subProb){
        switch (subProb){
            case 4:
                return Math.pow(x,3)+(2*Math.pow(x,2))+x-1;
            case 3:
                return Math.pow(x,3)-48;
            case 2:
                return Math.pow(Math.E,-x)-x;
            case 1:
                return Math.pow(x,3)-x-1;
            default:
                System.err.println("Wrong subproblem input");
                return Double.NaN;
        }

    }
}
