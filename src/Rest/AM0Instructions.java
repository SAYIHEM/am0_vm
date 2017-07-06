package Rest;

import Operations.AM0.*;
import Operations.AM0.Arithmethic.*;
import Operations.AM0.Logical.*;

import java.util.HashMap;
import java.util.Map;

public class AM0Instructions {

    private static Map<String, Operation> instructions = new HashMap<>();
    private static AM0Instructions instance = null;

    private AM0Instructions() {

        // SetUp Operations.AM0.Operation-Map for Operations.AM0
        instructions.put("Operations.AM0.Logical.ADD", new ADD());
        instructions.put("Operations.AM0.Logical.MUL", new MUL());
        instructions.put("Operations.AM0.Logical.SUB", new SUB());
        instructions.put("Operations.AM0.Logical.DIV", new DIV());
        instructions.put("Operations.AM0.Logical.MOD", new MOD());
        instructions.put("Operations.AM0.Arithmethic.EQ", new EQ());
        instructions.put("Operations.AM0.Arithmethic.NE", new NE());
        instructions.put("Operations.AM0.Arithmethic.LT", new LT());
        instructions.put("Operations.AM0.Arithmethic.GT", new GT());
        instructions.put("Operations.AM0.Arithmethic.LE", new LE());
        instructions.put("Operations.AM0.Arithmethic.GE", new GE());
        instructions.put("Operations.AM0.LOAD", new LOAD());
        instructions.put("Operations.AM0.STORE", new STORE());
        instructions.put("Operations.AM0.LIT", new LIT());
        instructions.put("Operations.AM0.WRITE", new WRITE());
        instructions.put("Operations.AM0.READ", new READ());
        instructions.put("Operations.AM0.JMP", new JMP());
        instructions.put("Operations.AM0.JMC", new JMC());
    }
    
    public static Map<String, Operation> getInstructions() {

        if (instance == null) {

            instance = new AM0Instructions();
        }

        return instructions;
    }
}
