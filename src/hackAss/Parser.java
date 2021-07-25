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
            line = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(symbol());
    }

    public boolean hasMoreCommands() {
        //returns true when there is a command to parse on the current line
        return line != null;
    }
    public void advance(){
        //reads the next line of the text file
        try {
            System.out.println(line);
            //String testOut = String.format("dest: %s, comp: %s, jump: %s, symbol: %s", dest(), comp(), jump(), symbol());
            //System.out.println(testOut);
            line = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    private String commandType() {
        //returns the instruction type (A, C or L) - address, compute, label
        if (line.contains("=")||line.contains(";")){
            return "C"; // C Command
        }
        else if (line.startsWith("@")){
            return "A"; // A Command
        }
        else if (line.startsWith("(")){
            return "L"; // L Command
        }
        else return null;

    }

    private String symbol() {
        String commandType = commandType();
        if ((commandType == "L") || (commandType == "A")) {
            return line.substring(1, line.length());
        }
        else return null;
    }

    private String dest() {
        if (commandType() == "C") {
            if (line.contains("=")){
                int eqPos = line.indexOf("=");
                return line.substring(0, eqPos);
            }
            else return null;
        }
        else return null;
    }

    private String comp() {
        if (commandType() == "C") {
            if (line.contains("=")) {
                int eqPos = line.indexOf("=");
                if (line.contains(";")) {
                    int scPos = line.indexOf(";");
                    return line.substring(eqPos+1, scPos);
                }
                else {
                    return line.substring(eqPos+1, line.length());
                }
            }
            else {
                if (line.contains(";")) {
                    int scPos = line.indexOf(";");
                    return line.substring(0, scPos);
                }
                else return line.substring(0,line.length());
            }
        }
            else return null;
    }

    private String jump() {
        if (commandType() == "C"){
            if (line.contains(";")){
                int scPos = line.indexOf(";");
                return line.substring(scPos+1, line.length());

            }
            else return null;
        }
        else return null;
    }
}
