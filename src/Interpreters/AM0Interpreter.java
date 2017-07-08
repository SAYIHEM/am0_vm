package Interpreters;

import Constants.ArgPatterns;
import InstructionSets.Instructions;
import Operations.AM0.AM0operation;
import InstructionSets.AM0Instructions;
import Constants.Colors;

import java.util.Map;

public class AM0Interpreter implements Interpreter {

    private Map<String, AM0operation> instructions;

    public AM0Interpreter(Instructions instructions) {

        if (instructions == null) throw new NullPointerException("Instructions to set were NULL!");
        if (!(instructions instanceof AM0Instructions)) System.out.println(Colors.RED + "Warning: Using InstructionSet that is not AM0!" + Colors.RESET);

        this.instructions = instructions.getInstructions();

    }

    public void execute(String command) {

        // Exceptions
        if (command == null) throw new NullPointerException("Command to execute was NULL!");
        if (command.isEmpty()) throw new IllegalArgumentException("Command was empty!");

        // Test command string
        if (!(command.matches(ArgPatterns.AM0_COMMAND)))
            throw new IllegalArgumentException("Error in " + this.getClass().getSimpleName() + ". Command was '" + command + "'.");

        String[] args = command.split(" ");
        String operation = args[0];
        String arg = (args.length == 2) ? args[1] : "";

        // Exceptions
        if (!this.instructions.containsKey(operation)) throw new IllegalArgumentException("Wrong OperationName in Command: " + command);

        // Run Command
        this.instructions.get(args[0]).run(arg);
    }
}
