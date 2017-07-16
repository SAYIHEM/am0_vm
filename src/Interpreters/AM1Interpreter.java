package Interpreters;

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

        if (!command.contains(" ")) {

            operation = command;   // TODO: Filter with RegEx!
            arg = "";

        } else {

            operation = command.substring(0, command.indexOf(' '));
            arg = command.substring(command.indexOf(' ') + 1);
        }


        // Exceptions
        if (!this.instructions.containsKey(operation)) throw new IllegalArgumentException("Wrong OperationName in Command: " + command);

        // Run Command
        this.instructions.get(operation).run(arg);
    }
}
