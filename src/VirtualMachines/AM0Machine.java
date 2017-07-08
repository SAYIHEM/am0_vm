package VirtualMachines;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Peripherals.Device;
import Hardware.Peripherals.Soundcard;
import InstructionSets.AM0Instructions;
import Interpreters.AM0Interpreter;
import Hardware.Stacks.Stack;

import java.util.ArrayList;
import java.util.List;

public class AM0Machine {

    private CommandPointer commandPointer = new CommandPointer();
    private Stack runtimeStack = new Stack();
    private Heap runtimeHeap = new Heap();


    private final int SOUND_FREQ = 1, SOUND_TIME = 2, SOUND_VOL = 3;


    Device[] devices = {
            new Soundcard(8000f, runtimeHeap, SOUND_FREQ, SOUND_TIME, SOUND_VOL)
    };

    private void handlePeripherals()
    {
        for(Device device : devices)
            device.update();
    }

    public AM0Machine()
    {
        commandPointer = new CommandPointer();
        runtimeStack = new Stack();
        runtimeHeap = new Heap();
    }

    public AM0Machine(String[] program)
    {
        commandPointer = new CommandPointer();
        runtimeStack = new Stack();
        runtimeHeap = new Heap();
        run(program);
    }

    public void run(String[] program) {

        AM0Interpreter interpreter = new AM0Interpreter(new AM0Instructions(runtimeHeap, runtimeStack, commandPointer));

        while(commandPointer.getValue() < program.length) {

            System.out.println(program[commandPointer.getValue()]);
            interpreter.execute(program[commandPointer.getValue()]);

            handlePeripherals();
        }

        System.out.println("Program terminated...");
    }
}
