/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class STORE extends Operation{

    public STORE() {

        super();
        this.name = "STORE";
    }

    @Override
    public void run(Integer arg) {

        Integer value = this.stack.pop();
        this.heap.STORE(arg, value);
    }
}
