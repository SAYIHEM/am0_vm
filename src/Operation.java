public abstract class Operation {

    protected String name;
    protected Stack stack;
    protected Heap heap;


    public Operation() {

        this.stack = Stack.getInstance();
        this.heap = Heap.getInstance();
    }

    public abstract void run(String arg);

    public String getName() {

        return this.name;
    }

}
