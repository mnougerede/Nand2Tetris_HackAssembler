package hackAss;

import java.io.File;
import java.io.IOException;

public class Output {
    public Output(String filename) {
        int dotPos = filename.indexOf(".");
        String newFilename = filename.substring(0,dotPos+1).concat("hack");
        File file = new File(newFilename);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
