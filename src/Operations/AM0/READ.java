package Operations.AM0;

import java.util.Scanner;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class READ extends Operation {

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";


    public READ()
    {
        this.name = "READ";
    }

    @Override
    public void run(Integer arg) {
        System.out.print(ANSI_BLUE_BACKGROUND + ANSI_BLACK + "INPUT <-" + ANSI_RESET + " ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        this.heap.STORE(arg, Integer.parseInt(input));
        increment();
    }
}
