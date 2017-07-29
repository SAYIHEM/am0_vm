package Interpreters;

import Constants.ArgPatterns;
import Constants.Colors;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import GUI.Controller.EventOutput;
import InstructionSets.Instructions;
import InstructionSets.AM0Instructions;
import Constants.ColorConsole;
import Operations.Operation;

import java.util.Map;

public class AM0Interpreter implements Interpreter {

    private Map<String, Operation> instructions;

    public AM0Interpreter(Instructions instructions) {

        if (instructions == null) throw new NullPointerException("Instructions to set were NULL!");
        if (!(instructions instanceof AM0Instructions)) System.out.println(ColorConsole.RED + "Warning: Using InstructionSet that is not AM0!" + ColorConsole.RESET);

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
        try {

            this.instructions.get(args[0]).run(arg);

        } catch (HeapException | StackException | InvalidOperationArgumentException e) {

            // ErrorOutput
            EventOutput.add(e.getMessage(), Colors.RED);
        }
    }
}
