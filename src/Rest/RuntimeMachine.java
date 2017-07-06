package Rest;

/**
 * Created by X0R_R0X on 7/6/2017.
 */
public class RuntimeMachine {

    public static void main(String[] argv) {

        System.out.println("Program start...");

        String[] program1 = {
                "READ 1",
                "READ 2",
                "LOAD 1",
                "LOAD 2",
                "GT",
                "JMC 9",
                "LOAD 1",
                "STORE 3",
                "JMP 11",
                "LOAD 2",
                "STORE 3",
                "WRITE 3"
        };

        String[] program2 = {
                "READ 1",
                "LOAD 1",
                "LIT 1",
                "GT",
                "JMC 11",
                "LOAD 1",
                "LIT 2",
                "Logical.DIV",
                "STORE 1",
                "WRITE 1",
                "JMP 1"
        };

        CommandPointer stackPointer = CommandPointer.getInstance();
        AM0Interpreter command = new AM0Interpreter();

        String[] program = program1;

        if (argv.length != 0) {

            program = argv[0].split(",");
        }

        while(stackPointer.getValue() < program.length) {

            System.out.println(program[stackPointer.getValue()]);
            command.execute(program[stackPointer.getValue()]);
        }


        System.out.println("Program terminated...");
    }
}
