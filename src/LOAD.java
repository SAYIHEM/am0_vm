public class LOAD extends Operation{

    public LOAD() {

        this.name = "LOAD";
    }

    @Override
    public void run(Integer arg) {
        this.stack.push(this.heap.LOAD(arg));
    }
}
