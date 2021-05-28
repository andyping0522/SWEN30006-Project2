package cribbage;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class MyLogger {
    private static final String FNAME= "cribbage.log";

    public void WriteToFile(String msg){
        
        try {
            FileWriter fileWriter = new FileWriter(FNAME);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(msg+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
