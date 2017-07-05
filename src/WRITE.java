/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class WRITE extends Operation {

    public WRITE()
    {
        this.name = "WRITE";
    }

    @Override
    public void run(Integer arg) {
        System.out.println(this.heap.LOAD(arg));
        increment();
    }
}
