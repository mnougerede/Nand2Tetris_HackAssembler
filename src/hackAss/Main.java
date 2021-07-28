package hackAss;

public class Main {
    public static void main(String[] args){
        Parser parser = new hackAss.Parser(args[0]);
        Output output = new Output(args[0]);
//        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\add\\Add.asm");
//        Parser parser = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\rect\\Rect.asm");
//        Output output = new Output("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\rect\\Rect.asm");
        System.out.println("created output instance");
        SymbolTable symbolTable = new SymbolTable();
        System.out.println("created symbolTable instance");
        System.out.println("parser has more commands: " + parser.hasMoreCommands());
        //TODO add main program logic for symbolTable
        int lineNumber = 0;
        int nextRAM = 16;
        while (parser.hasMoreCommands()) {
            System.out.println("Command type is: " + parser.commandType());
            if (parser.commandType().equals("L")) {
                symbolTable.addEntry(parser.symbol(), lineNumber);
//                System.out.println("encountered L command and added this address to symbol table: " + symbolTable.getAddress(parser.symbol()));
            }
            if (parser.commandType().equals("A") || parser.commandType().equals("C")) {
                lineNumber++;
//                System.out.println("encountered A or C command, line number is now: " + lineNumber);
            }
            parser.advance();
        }
//        Parser parser2 = new Parser("C:\\Users\\mnoug\\Study\\Coursera\\Nand2Tetris\\source files\\nand2tetris\\projects\\06\\rect\\Rect.asm");
        Parser parser2 = new Parser(args[0]);
        while (parser2.hasMoreCommands()) {
            System.out.println("Command type is: " + parser2.commandType());
            System.out.println("symbol is: " + parser2.symbol());
            if (parser2.commandType().equals("C")) {
                String commandString = "111";
                String compMnemonic = parser2.comp();
                String comp = Code.comp(compMnemonic);
                String destMnemonic = parser2.dest();
                String dest = Code.dest(destMnemonic);
                String jumpMnemonic = parser2.jump();
                String jump = Code.jump(jumpMnemonic);
                commandString = commandString.concat(comp + dest + jump);
                System.out.println("c = " + commandString);

                output.write(commandString);

            }
            else if (parser2.commandType().equals("A")) {
                int address;
                if (isNumeric(parser2.symbol())) {
                    address = Integer.parseInt(parser2.symbol());



                }
                else {
                    if (!symbolTable.contains(parser2.symbol())) {
                        symbolTable.addEntry(parser2.symbol(), nextRAM);
                        nextRAM++;
                    }
                    address = symbolTable.getAddress(parser2.symbol());
                }
                String addressBinary = Integer.toBinaryString(0x10000 | address).substring(1);
                System.out.println("a = " + addressBinary);
                output.write(addressBinary);

            }
            parser2.advance();
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
