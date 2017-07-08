package VirtualMachines;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Peripherals.Device;
import Hardware.Peripherals.Soundcard;
import InstructionSets.AM0Instructions;
import Interpreters.AM0Interpreter;
import Hardware.Stacks.Stack;
import Logs.Log;

import java.util.ArrayList;
import java.util.List;

public class AM0Machine extends RuntimeMachine {

    private CommandPointer commandPointer;
    private Stack runtimeStack;
    private Heap runtimeHeap;


    private final int SOUND_FREQ = 1, SOUND_TIME = 2, SOUND_VOL = 3;
    private List<Device> devices;

    private void handlePeripherals()
    {
        for(Device device : devices)
            device.update();
    }

    public AM0Machine()
    {
        init();
    }

    public AM0Machine(String[] program)
    {
        init();
        run(program);
    }

    private void init() {

        commandPointer = new CommandPointer();
        runtimeStack = new Stack();
        runtimeHeap = new Heap();

        this.devices = new ArrayList<>();
        this.devices.add(new Soundcard(8000f, runtimeHeap, SOUND_FREQ, SOUND_TIME, SOUND_VOL));
    }

    public void run(String[] program) {

        AM0Interpreter interpreter = new AM0Interpreter(new AM0Instructions(runtimeHeap, runtimeStack, commandPointer));

        while(commandPointer.getValue() < program.length) {

            Log.d("AM0", commandPointer.getValue() + "\t" +program[commandPointer.getValue()]);
            interpreter.execute(program[commandPointer.getValue()]);

            handlePeripherals();
        }
    }
}
