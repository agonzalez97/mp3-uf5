package christmas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jordi on 13/12/16.
 */
public class PareNoelregexp {
    private static final String PathFitxer = "src/christmas/santako.txt";


    public static void main(String[] args) {
        Pattern PareNoel = Pattern.compile("([\\*{1}])([\\<\\]\\:\\-\\[DOo\\]])");
        Pattern Ren = Pattern.compile(">:o\\)");
        Pattern Follet = Pattern.compile("[^\\*]<]:-D");

        BufferedReader br = null;
        FileReader fr = null;
        int numPN = 0;
        int numRen = 0;
        int numF = 0;

        try {
            fr = new FileReader(PareNoelregexp.PathFitxer);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null) {
                Matcher mpn = PareNoel.matcher(line);
                Matcher mren = Ren.matcher(line);
                Matcher mfollet = Follet.matcher(line);

                while (mpn.find()) numPN++;
                while (mren.find()) numRen++;
                while (mfollet.find()) numF++;
                if(numPN > 0) System.out.print(" Pare Noel (" + numPN + ")");
                if(numRen > 0) System.out.print(" Ren (" + numRen + ")");
                if(numF > 0) System.out.print(" Follet (" + numF + ")");
                line = br.readLine();
                numPN = numF = numRen = 0;
                System.out.println();
            }

        }catch (IOException e) {
            e.getStackTrace();
        }

    }


}
