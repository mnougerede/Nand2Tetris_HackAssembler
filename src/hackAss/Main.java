package hackAss;

public class Main {
    public static void main(String[] args){
        // hackAss.Parser parser = new hackAss.Parser(args[0]);
//        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\add\\Add.asm");
        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\rect\\RectL.asm");

        //these for testing only
        //System.out.println(parser.hasMoreCommands());
//        System.out.println(parser.commandType());
//        if (parser.hasMoreCommands()) {
//            parser.advance();
//        }
        while (parser.hasMoreCommands()) {
            parser.advance();
        }

    }
}
