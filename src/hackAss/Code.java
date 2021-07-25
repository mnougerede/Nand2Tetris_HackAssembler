package hackAss;


import java.util.Hashtable;

public class Code {
    public String dest(String mnemonic){
        //TODO write dest method
        Hashtable<String,String> destTable = new Hashtable<>();

        destTable.put(null, "000");
        destTable.put("M", "001");
        destTable.put("D", "010");
        destTable.put("MD", "011");
        destTable.put("A", "100");
        destTable.put("AM", "101");
        destTable.put("AD", "110");
        destTable.put("AMD", "111");

        return destTable.get(mnemonic);
    }
    public String comp(String mnemonic){
        //TODO write comp method
        Hashtable<String,String> compTable = new Hashtable<>();

        compTable.put("0","0101010");
        compTable.put("1","0111111");
        compTable.put("-1","0111010");
        compTable.put("D","0001100");
        compTable.put("A","0110000");
        compTable.put("!D","0001101");
        compTable.put("!A","0110000");
        compTable.put("-D","0001111");
        compTable.put("-A","0110011");
        compTable.put("D+1","0011111");
        compTable.put("A+1","0110111");
        compTable.put("D-1","0001110");
        compTable.put("A-1","0110010");
        compTable.put("D+A","0000010");
        compTable.put("D-A","0010011");
        compTable.put("A-D","0000111");
        compTable.put("D&A","0000000");
        compTable.put("D|A","0010101");
        compTable.put("M","1110000");
        compTable.put("!M","1110001");
        compTable.put("-M","1110011");
        compTable.put("M+1","1110111");
        compTable.put("M-1","1110010");
        compTable.put("D+M","1000010");
        compTable.put("D-M","1010011");
        compTable.put("M-D","1000111");
        compTable.put("D&M","1000000");
        compTable.put("D|M","1010101");

        return compTable.get(mnemonic);

    }
    public String jump(String mnemonic){
        //TODO write jump method
        Hashtable<String, String> jumpTable = new Hashtable<>();

        jumpTable.put(null, "000");
        jumpTable.put("JGT", "001");
        jumpTable.put("JEQ", "010");
        jumpTable.put("JGE", "011");
        jumpTable.put("JLT", "100");
        jumpTable.put("JNE", "101");
        jumpTable.put("JLE", "110");
        jumpTable.put("JMP", "111");

        return jumpTable.get(mnemonic);
    }
}
