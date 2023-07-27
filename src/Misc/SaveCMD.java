package Misc;

import java.io.FileWriter;

public class SaveCMD {

    public static void save(String content) {
        try {
            // This method adds the input to the DATASTORAGE.MEAM file
            FileWriter fw = new FileWriter("DATASTORAGE.MEAM", true);
            fw.write(content + "\n");
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
