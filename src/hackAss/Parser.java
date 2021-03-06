package hackAss;

import java.io.*;


public class Parser {
    private BufferedReader br;
    private String line;

    public Parser(String filename) {
        // opens the input file and gets ready to parse it
        File file = new File(filename);
        this.br = null;
        try {
            //This class accesses the input file, removes its whitespace and parses each instruction
            FileReader fr = new FileReader(file);
            this.br = new BufferedReader(fr);
            line = br.readLine().trim();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(symbol());
    }

    public boolean hasMoreCommands() {
        //returns true when there is a command to parse on the current line
        return line != null;
    }
    public void advance(){
        //reads the next line of the text file
        try {
            System.out.println(line);
            String testOut = String.format("dest: %s, comp: %s, jump: %s, symbol: %s", dest(), comp(), jump(), symbol());
            System.out.println(testOut);
            line = br.readLine();
            if (line != null) line = line.trim();
            if (!hasMoreCommands()) br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String commandType() {
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
        else return "";

    }

    public String symbol() {
        if (commandType().equals("A")) {
            return line.substring(1);
        }
        else if (commandType().equals("L")) {
            return line.substring(1,line.length()-1);
        }
        else return null;
    }

    public String dest() {
        if (commandType().equals("C")) {
            if (line.contains("=")){
                int eqPos = line.indexOf("=");
                return line.substring(0, eqPos);
            }
            else return "";
        }
        else return null;
    }

    public String comp() {
        if (commandType().equals("C")) {
            if (line.contains("=")) {
                int eqPos = line.indexOf("=");
                if (line.contains(";")) {
                    int scPos = line.indexOf(";");
                    return line.substring(eqPos+1, scPos);
                }
                else {
                    return line.substring(eqPos+1);
                }
            }
            else {
                if (line.contains(";")) {
                    int scPos = line.indexOf(";");
                    return line.substring(0, scPos);
                }
                else return line;
            }
        }
            else return null;
    }

    public String jump() {
        if (commandType().equals("C")){
            if (line.contains(";")){
                int scPos = line.indexOf(";");
                return line.substring(scPos+1);

            }
            else return "";
        }
        else return null;
    }
}
