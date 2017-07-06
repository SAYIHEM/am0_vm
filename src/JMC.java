/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class JMC extends Operation {

    public JMC()
    {
        this.name = "JMC";
    }

    @Override
    public void run(Integer arg) {
        Integer value = this.runtimeStack.pop();
        if(value == 0) {

            this.stackPointer.setValue(arg);

        } else {

            increment();
        }

    }
}
