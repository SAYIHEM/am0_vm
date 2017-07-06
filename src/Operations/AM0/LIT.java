package Operations.AM0;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class LIT  extends Operation {

    public LIT() {

        this.name = "LIT";
    }

    @Override
    public void run(Integer arg) {

        this.runtimeStack.push(arg);
        increment();
    }
}
