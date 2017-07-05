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

    private final Integer ADDRESS_MAX = 0xFFFF;

    private Integer[] heap = new Integer[ADDRESS_MAX];

    public void STORE(Integer address, Integer value)
    {
        if(address < 0 || address >= ADDRESS_MAX)
            throw new StackException("STORE error. address out of bounds!");
        heap[address] = value;
    }

    public Integer LOAD(Integer address)
    {
        if(address < 0 || address >= ADDRESS_MAX)
            throw new StackException("READ error. address out of bounds!");
        return heap[address];
    }
}
