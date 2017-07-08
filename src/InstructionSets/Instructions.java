package InstructionSets;

import Operations.AM0.AM0operation;

import java.util.HashMap;
import java.util.Map;

public abstract class Instructions {

    protected Map<String, AM0operation> instructions = new HashMap<>();

    public abstract Map<String, AM0operation> getInstructions();
}
