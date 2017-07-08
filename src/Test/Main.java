package Test;

import VirtualMachines.AM0Machine;

/**
 * Created by X0R_R0X on 7/6/2017.
 */
public class Main {

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

        String[] program3 = {
                "LIT 1",
                "LIT 1",
                "ADD",
                "STORE 1",
                "WRITE 1"
        };

        AM0Machine vm = new AM0Machine();
        vm.run(program2);

    }
}
