package InstructionSets;

import Operations.AM0.*;
import Operations.AM0.Arithmethic.*;
import Operations.AM0.Logical.*;

import java.util.Map;

public class AM0Instructions extends Instructions {

    public AM0Instructions() {

        // SetUp AM0.Operation-Map for AM0
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

    public Map<String, Operation> getInstructions() {

        return instructions;
    }
}
