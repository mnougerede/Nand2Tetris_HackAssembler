package hackAss;

import java.io.*;


public class Parser {
    //This class accesses the input file, removes its whitespace and parses each instruction
    private FileReader fr;
    private BufferedReader br;
    private File file;
    private String line;

    public Parser(String filename) {
        // opens the input file and gets ready to parse it
        this.file = new File(filename);
        this.br = null;
        try {
            this.fr = new FileReader(file);
            this.br = new BufferedReader(this.fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasMoreCommands() {
        //returns true when there is a command to parse on the current line
        return line != null;
    }
    public void advance(){
        //reads the next line of the text file
        try {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private String commandType() {
        //returns the instruction type (A, C or L) - address, compute, label
        if (line.contains("=")||line.contains(";")){
            return "C_COMMAND";
        }
        else if (line.startsWith("@")){
            return "A_COMMAND";
        }
        else if (line.startsWith("(")){
            return "L_COMMAND";
        }
        else return null;

    }

    private String symbol() {
        //TODO build symbol method
        return "";
    }

    private String dest() {
        //TODO build dest method
        return "";
    }

    private String comp() {
        //TODO build comp method
        return "";
    }

    private String jump() {
        //TODO build jump method
        return "";
    }
}
