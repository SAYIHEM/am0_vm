package InstructionSets;

import Operations.AM0.Operation;

import java.util.HashMap;
import java.util.Map;

public abstract class Instructions {

    protected Map<String, Operation> instructions = new HashMap<>();

    public abstract Map<String, Operation> getInstructions();
}
