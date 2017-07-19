package Interpreters;

import Constants.ArgPatterns;
import Constants.Colors;
import InstructionSets.AM1Instructions;
import InstructionSets.Instructions;
import Operations.Operation;

import java.util.Map;

public class AM1Interpreter implements Interpreter {

    private Map<String, Operation> instructions;

    public AM1Interpreter(Instructions instructions) {

        if (instructions == null) throw new NullPointerException("Instructions to set were NULL!");
        if (!(instructions instanceof AM1Instructions)) System.out.println(Colors.RED + "Warning: Using InstructionSet that is not AM1!" + Colors.RESET);

        this.instructions = instructions.getInstructions();
    }

    @Override
    public void execute(String command) {

        // Exceptions
        if (command == null) throw new NullPointerException("Command to execute was NULL!");
        if (command.isEmpty()) throw new IllegalArgumentException("Command was empty!");

        String operation;
        String arg;

        // For command without parameter
        if (command.matches(ArgPatterns.COMMAND_SINGLE)) {

            operation = command;
            arg = "";

        // For command with parameter
        } else if (command.matches(ArgPatterns.COMMAND_PARAMETER)) {

            operation = command.substring(0, command.indexOf(' '));
            arg = command.substring(command.indexOf(' ') + 1);

        } else {

            throw new IllegalArgumentException(Colors.RED + "Could not parse command! Command was: " + command + Colors.RESET);
        }


        // Exceptions
        if (!this.instructions.containsKey(operation)) throw new IllegalArgumentException("Wrong OperationName in Command: " + command);

        // Run Command
        this.instructions.get(operation).run(arg);
    }
}
