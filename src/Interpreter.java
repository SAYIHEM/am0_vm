import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by X0R_R0X on 7/6/2017.
 */
public class Interpreter {

    public static void main(String[] argv) {

        System.out.println("Program start..");

        String[] program = {
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

        StackPointer stackPointer = StackPointer.getInstance();
        AM0Command command = new AM0Command();


        while(stackPointer.getValue() < program.length) {

            command.compileAndExecute(program[stackPointer.getValue()]);
        }

        System.out.println("Program exec..");
    }
}
