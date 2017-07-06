package Operations.AM0;

public class LOAD extends Operation {

    public LOAD() {

        this.name = "Operations.AM0.LOAD";
    }

    @Override
    public void run(Integer arg) {

        this.runtimeStack.push(this.heap.LOAD(arg));
        increment();
    }
}
