import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class Heap {
    private static Heap instance = new Heap();
    public static Heap getInstance()
    {
        return instance;
    }

    private Integer[] heap = new Integer[100];

}
