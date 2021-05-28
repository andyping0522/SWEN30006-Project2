package cribbage;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MyLogger {
    private static final String FNAME= "cribbage.log";

    public void WriteToFile(String msg){

        PrintWriter pw = null;
        try {
            File file = new File(FNAME);
            FileWriter fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
            pw.println(msg);
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

}
