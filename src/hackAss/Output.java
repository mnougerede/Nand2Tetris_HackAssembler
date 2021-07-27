package hackAss;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Output {
    private String outFilename;
    public Output(String filename) {
        int dotPos = filename.indexOf(".");
        outFilename = filename.substring(0,dotPos+1).concat("hack");
        File file = new File(outFilename);
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
    public void write(String command) {
        //TODO complete the write method - writes a line to the output file
        try {
//            System.out.println("file name is: " + outFilename);
            FileWriter myWriter = new FileWriter(outFilename, true);
            myWriter.write(command);
            myWriter.write(System.getProperty( "line.separator" ));
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
