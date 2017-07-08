package Test;


import Hardware.Peripherals.Soundcard;
import Logs.Log;
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
                "Logical.DIV",
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

        ///plays funny sound
        String[] program4 = {
                "LIT 75", //full volume
                "LIT 200", //play 200ms
                "LIT 800", //play 600Hz tone
                "STORE 1", //
                "STORE 2", //push to device buffer
                "STORE 3"  //
        };

        AM0Machine machine = new AM0Machine(program1);


        System.out.println("Program terminated...");
    }
}
