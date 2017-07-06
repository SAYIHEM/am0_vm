package Operations.AM0;

import Singletons.Colors;

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
        System.out.println(Colors.RED_BACK + Colors.BLACK + "OUTPUT ->" + Colors.RESET + " " + arg);
        increment();
    }
}
