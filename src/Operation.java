public abstract class Operation {

    protected String name;
    protected Stack stack = Stack.getInstance();
    protected Heap heap = Heap.getInstance();
    protected StackPointer stackPointer = StackPointer.getInstance();

    public abstract void run(Integer arg);

    public String getName() {

        return this.name;
    }

}
