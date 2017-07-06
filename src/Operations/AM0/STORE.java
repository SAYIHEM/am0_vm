package Operations.AM0;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class STORE extends Operation {

    public STORE() {

        this.name = "Operations.AM0.STORE";
    }

    @Override
    public void run(Integer arg) {

        Integer value = this.runtimeStack.pop();
        this.heap.STORE(arg, value);
        increment();
    }
}