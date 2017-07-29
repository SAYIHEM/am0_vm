package Test;


import Exceptions.InvalidStartConfigException;
import Tools.FileArrayProvider;
import VirtualMachines.AM1Machine;

import java.io.IOException;

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

        ///annoys you by beeping real HARDDDDD
        String[] program4 = {
                "LIT 1", // volume
                "LIT 500", //play 200ms
                "LIT 800", //play 600Hz tone
                "STORE 1334", //
                "STORE 1335", //push to device buffer
                "STORE 1336",
                "JMP 0"//
        };

        ///draws a line on screen
        String[] program5 = {
                "LIT 1",
                "LIT 1",
                "LIT 1",
                "LIT 1",
                "STORE 1337",
                "STORE 1338",
                "STORE 1339",
                "STORE 1340"
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
                "STORE 1337",
                "JMP 11",
                "LIT 0",
                "STORE 1337",
                "LIT 1",
                "LOAD 5",
                "ADD",
                "STORE 5",
                "JMP 2"
        };

        //address of display is 1337
        String[] program7 = {
                "LIT 0",
                "STORE 5",
                "LOAD 5",
                "LIT 50",
                "GT",
                "JMC 9",
                "LIT 1",
                "STORE 1337",
                "JMP 11",
                "LIT 0",
                "STORE 1337",
                "LOAD 5",
                "LIT 100",
                "LT",
                "JMC 0",
                "LIT 1",
                "LOAD 5",
                "ADD",
                "STORE 5",
                "JMP 2"
        };

        //AM0 test, blinking a pixel
        //AM0Machine am0Machine = new AM0Machine();
        //am0Machine.run(program7);


        try {

            /*String[] program = FileArrayProvider.readLines("res/prog.am1");
            AM1Machine am1Machine = new AM1Machine();
            am1Machine.setStartConfig("(12, -, 0 : 3 : 0, 3, 9, -)");
            am1Machine.run(program);*/

            String[] program = FileArrayProvider.readLines("res/prog.am1");
            AM1Machine am1Machine = new AM1Machine();
            am1Machine.setStartConfig("(12, -, 0 : 3 : 0, 3, 9, -)");
            am1Machine.run(program);


        } catch (InvalidStartConfigException | IOException e) {
            e.printStackTrace();
        }

        //AM0Machine machine = new AM0Machine(program5);
        //System.out.println(machine.getOutput());

    }
}
