package hackAss;

import java.util.Hashtable;

public class SymbolTable {
    //TODO build hackAss.SymbolTable class (builds and populates symbol table)
    private Hashtable<String, Integer> symbolTable;
    public SymbolTable() {
        Hashtable<String,String> symbolTable = new Hashtable<>();
    }
    public void addEntry(String symbol, int address){
        //TODO write addEntry method
        symbolTable.put(symbol,address);
    }
    public boolean contains(String symbol) {
        //TODO write contains method
    }
    public int getAddress(String symbol) {
        //TODO write getAddress method

    }
}
