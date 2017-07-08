package VirtualMachines;


public abstract class RuntimeMachine {

    protected String output = "";
    protected String[] program = {};

    public RuntimeMachine() {}

    // Constructor to exec program
    public RuntimeMachine(String[] program) {

        if (program == null) throw new NullPointerException("Program to set was NULL!");
        if (program.length == 0) throw new IllegalArgumentException("Program to set was empty!");

        run(program);
    }

    public abstract void run(String[] program);

    public String getOutput() {

        return this.output;
    }

}
