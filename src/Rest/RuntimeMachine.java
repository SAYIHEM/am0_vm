package Rest;

/**
 * Created by X0R_R0X on 7/6/2017.
 */
public class RuntimeMachine {

    public static void main(String[] argv) {

        System.out.println("Program start...");

        String[] program1 = {
                "Operations.AM0.READ 1",
                "Operations.AM0.READ 2",
                "Operations.AM0.LOAD 1",
                "Operations.AM0.LOAD 2",
                "Operations.AM0.Arithmethic.GT",
                "Operations.AM0.JMC 9",
                "Operations.AM0.LOAD 1",
                "Operations.AM0.STORE 3",
                "Operations.AM0.JMP 11",
                "Operations.AM0.LOAD 2",
                "Operations.AM0.STORE 3",
                "Operations.AM0.WRITE 3"
        };

        String[] program2 = {
                "Operations.AM0.READ 1",
                "Operations.AM0.LOAD 1",
                "Operations.AM0.LIT 1",
                "Operations.AM0.Arithmethic.GT",
                "Operations.AM0.JMC 11",
                "Operations.AM0.LOAD 1",
                "Operations.AM0.LIT 2",
                "Operations.AM0.Logical.DIV",
                "Operations.AM0.STORE 1",
                "Operations.AM0.WRITE 1",
                "Operations.AM0.JMP 1"
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
