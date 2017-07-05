import java.util.HashMap;
import java.util.Map;

public class AM0Command implements Command {

    private Map<String, Operation> instructions = new HashMap<>();

    public AM0Command() {

    }

    @Override
    public void compileAndExecute(String command) {

        // Exceptions
        if (command == null) throw new NullPointerException("Command to execute was NULL!");
        if (command.isEmpty()) throw new IllegalArgumentException("");

        String[] args = command.split(" ");

        int cmd = 0;
        if (args.length > 1) {

            try {

                cmd = Integer.parseInt(args[1]);

            } catch (NumberFormatException e) {

                System.out.println("Illegal Argument in Command: " + command);
            }
        }

        // Exceptions
        if (!this.instructions.containsKey(args[0])) throw new IllegalArgumentException("Wrong OperationName in Command: " + command);


        this.instructions.get(args[0]).run(cmd);


    }
}
