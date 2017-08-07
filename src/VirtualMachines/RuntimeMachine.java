package VirtualMachines;


import OutputHandler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class RuntimeMachine {

    protected String[] program = {};
    protected OutputHandler output;


    public RuntimeMachine() {}

    // Constructor to exec program
    public RuntimeMachine(String[] program) {

        if (program == null) throw new NullPointerException("Program to set was NULL!");
        if (program.length == 0) throw new IllegalArgumentException("Program to set was empty!");

        run(program);
    }

    public abstract void run(String[] program);

    public String getOutput() {

        return this.output.get();
    }

}
