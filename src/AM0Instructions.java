import java.util.HashMap;
import java.util.Map;

public class AM0Instructions {

    private static Map<String, Operation> instructions = new HashMap<>();
    private static AM0Instructions instance = null;

    private AM0Instructions() {

        // SetUp Operation-Map for AM0
        instructions.put("ADD", new ADD());
        instructions.put("MUL", new MUL());
        instructions.put("SUB", new SUB());
        instructions.put("DIV", new DIV());
        instructions.put("MOD", new MOD());
        instructions.put("EQ", new EQ());
        instructions.put("NE", new NE());
        instructions.put("LT", new LT());
        instructions.put("GT", new GT());
        instructions.put("LE", new LE());
        instructions.put("GE", new GE());
        instructions.put("LOAD", new LOAD());
        instructions.put("STORE", new STORE());
        instructions.put("LIT", new LIT());
        instructions.put("WRITE", new WRITE());
        instructions.put("READ", new READ());
        instructions.put("JMP", new JMP());
        instructions.put("JMC", new JMC());
    }
    
    public static Map<String, Operation> getInstructions() {

        if (instance == null) {

            instance = new AM0Instructions();
        }

        return instructions;
    }
}
