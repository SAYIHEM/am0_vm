package Operations.AM0;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class WRITE extends Operation {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";


    public WRITE()
    {
        this.name = "Operations.AM0.WRITE";
    }

    @Override
    public void run(Integer arg) {
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + "OUTPUT ->" + ANSI_RESET + " " + arg);
        increment();
    }
}
