package VirtualMachines;


import java.util.ArrayList;
import java.util.List;

public abstract class RuntimeMachine {

    protected List<String> output = new ArrayList<>();
    protected String[] program = {};

    public RuntimeMachine() {}

    // Constructor to exec program
    public RuntimeMachine(String[] program) {

        if (program == null) throw new NullPointerException("Program to set was NULL!");
        if (program.length == 0) throw new IllegalArgumentException("Program to set was empty!");

        run(program);
    }

    public abstract void run(String[] program);

    public List<String> getOutput() {

        return this.output;
    }

}
