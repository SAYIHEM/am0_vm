/**
 * Created by X0R_R0X on 7/6/2017.
 */
public class Interpreter {

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
                "DIV",
                "STORE 1",
                "WRITE 1",
                "JMP 1"
        };

        StackPointer stackPointer = StackPointer.getInstance();
        AM0Command command = new AM0Command();

        String[] program = program1;

        if (argv.length != 0) {

            program = argv[0].split(",");
        }

        while(stackPointer.getValue() < program.length) {

            System.out.println(program[stackPointer.getValue()]);
            command.compileAndExecute(program[stackPointer.getValue()]);
        }



        System.out.println("Program exec...");

        // Program command line Input: "READ 1,LOAD 1,LIT 1,GT,JMC 11,LOAD 1,LIT 2,DIV,STORE 1,WRITE 1,JMP 1"
    }
}
