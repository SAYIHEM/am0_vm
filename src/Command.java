public abstract class Command {

    protected String name;
    protected Stack stack;
    protected Heap heap;


    public Command() {

        this.stack = Stack.getInstance();
        this.heap = Heap.getInstance();
    }

    public abstract void run(String arg);
}
