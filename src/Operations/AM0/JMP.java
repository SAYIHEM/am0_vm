package Operations.AM0;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class JMP extends Operation {

    public JMP()
    {
        this.name = "Operations.AM0.JMP";
    }

    @Override
    public void run(Integer arg) {
        this.stackPointer.setValue(arg);
    }
}
