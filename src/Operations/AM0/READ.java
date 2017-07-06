package Operations.AM0;

import Singletons.Colors;

import java.util.Scanner;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class READ extends Operation {

    public READ()
    {
        this.name = "READ";
    }

    @Override
    public void run(Integer arg) {
        System.out.print(Colors.BLUE_BACK + Colors.BLACK + "INPUT <-" + Colors.RESET + " ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        this.heap.STORE(arg, Integer.parseInt(input));
        increment();
    }
}
