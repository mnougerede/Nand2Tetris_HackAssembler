import java.io.*;
import java.util.Scanner;

public class Parser {
    /**This class accesses the input file, removes its whitespace and parses each instruction */
    public Parser(String filename) {
        // opens the input file and gets ready to pass it
        //TODO build Parser constructor (opens file to be read)
        BufferedReader reader = new BufferedReader(new FileReader(filename));
    }

    private boolean hasMoreCommands() {
        //TODO build hasMoreCommands method

    }
    private static void advance(){
        //TODO build advance method
    }

    private String commandType() {
        //TODO build commandType method
    }

    private String symbol() {
        //TODO build symbol method
    }

    private String dest() {
        //TODO build dest method
    }

    private String comp() {
        //TODO build comp method
    }

    private String jump() {
        //TODO build jump method
    }
}
