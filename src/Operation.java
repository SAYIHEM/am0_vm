public abstract class Operation {

    protected String name;
    protected Stack runtimeStack = RuntimeStack.getInstance();
    protected Heap heap = Heap.getInstance();
    protected CommandPointer stackPointer = CommandPointer.getInstance();

    public abstract void run(Integer arg);

    public String getName() {

        return this.name;
    }

    public void increment() {

        this.stackPointer.increment();
    }

}
