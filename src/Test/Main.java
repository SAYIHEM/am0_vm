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

        ///annoys you by beeping real HARDDDDD
        String[] program4 = {
                "LIT 1", // volume
                "LIT 500", //play 200ms
                "LIT 800", //play 600Hz tone
                "STORE 1", //
                "STORE 2", //push to device buffer
                "STORE 3",
                "JMP 0"//
        };

        ///draws a line on screen
        String[] program5 = {
                "LIT 1",
                "LIT 1",
                "LIT 1",
                "LIT 1",
                "STORE 10",
                "STORE 11",
                "STORE 12",
                "STORE 13",
                "LIT 1",
                "LIT 1",
                "LIT 1",
                "LIT 1",
                "STORE 22",
                "STORE 23",
                "STORE 24",
                "STORE 25"
        };




        //animation, blinks pixel
        String[] program6 = {
                "LIT 0",
                "STORE 5",
                "WRITE 5",
                "LOAD 5",
                "LIT 2",
                "MOD",
                "JMC 9",
                "LIT 1",
                "STORE 10",
                "JMP 11",
                "LIT 0",
                "STORE 10",
                "LIT 1",
                "LOAD 5",
                "ADD",
                "STORE 5",
                "JMP 2"
        };

        String[] program7 = {
                "LIT 1",
                "STORE 5",
                "WRITE 5"
        };


        AM0Machine machine = new AM0Machine(program6);
        System.out.println(machine.getOutput());


        System.out.println("Program terminated...");
    }
}
