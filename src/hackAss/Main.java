package hackAss;


public class Main {
    public static void main(String[] args){
        // hackAss.Parser parser = new hackAss.Parser(args[0]);
        //Output output = new Output(args[0]);
//        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\add\\Add.asm");
        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\rect\\RectL.asm");
        Output output = new Output("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\rect\\RectL.asm");
        SymbolTable symbolTable = new SymbolTable();
        //TODO add main program logic for symbolTable

        while (parser.hasMoreCommands()) {
            if (parser.commandType().equals("C")) {
                String commandString = "111";
                String compMnemonic = parser.comp();
                String comp = Code.comp(compMnemonic);
                String destMnemonic = parser.dest();
                String dest = Code.dest(destMnemonic);
                String jumpMnemonic = parser.jump();
                String jump = Code.jump(jumpMnemonic);
                commandString = commandString.concat(comp + dest + jump);
//                System.out.println("c = " + commandString);

                output.write(commandString);

            }
            else if (parser.commandType().equals("A")) {
                int address = Integer.parseInt(parser.symbol());
                String addressBinary = Integer.toBinaryString(0x10000 | address).substring(1);
//                String addressString = "0" + addressBinary; //this was to add a leading 0 for addresses
                output.write(addressBinary);
//                System.out.println("a = " + addressBinary);

            }
            parser.advance();
        }
    }
}
