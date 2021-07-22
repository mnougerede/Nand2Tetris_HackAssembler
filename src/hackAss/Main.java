package hackAss;

public class Main {
    public static void main(String[] args){
        // hackAss.Parser parser = new hackAss.Parser(args[0]);
        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\add\\Add.asm");


        //these for testing only
        parser.advance();
        parser.advance();
    }
}
