package cribbage;


import java.io.FileWriter;
import java.io.IOException;


public class MyLogger {
    private static final String FNAME= "cribbage.log";

    public void WriteToFile(String msg){
        try {
            FileWriter writer = new FileWriter(FNAME);
            writer.write(msg+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
