public abstract class Operation {

    protected String name;
    protected Stack stack = Stack.getInstance();
    protected Heap heap = Heap.getInstance();

    public abstract void run(Integer arg);

    public String getName() {

        return this.name;
    }

}
