package Hardware.Heaps;

import Exceptions.StackException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class Heap {

    private static Heap instance = new Heap();

    private final Integer ADDRESS_MAX = 0xFFFF;
    private Map<Integer, Integer> heap;

    public Heap()
    {
        heap =  new HashMap<>();
    }

    public void store(Integer address, Integer value)
    {
        if(address < 0 || address >= ADDRESS_MAX)
            throw new StackException("STORE error. address out of bounds!");
        heap.put(address, value);
    }

    public Integer load(Integer address)
    {
        if(address < 0 || address >= ADDRESS_MAX)
            throw new StackException("READ error. address out of bounds! Address was: " + address);

        Integer val = heap.get(address);
        if (val == null) throw new StackException("READ error. Value in address was NULL!");

        return val;
    }

    public void emptyfromAddress(int address) {

        Map<Integer, Integer> heapCopy = new HashMap<>(heap);

        for (Integer heapAddress : heapCopy.keySet()) {

            if (heapAddress > address && heapAddress <= getMaxAddress()) {

                heap.remove(heapAddress);
            }
        }
    }

    public Integer getMaxAddress() {

        int maxAddress = 0;

        for (Integer address : heap.keySet()) {

            maxAddress = address > maxAddress ? address : maxAddress;
        }

        return maxAddress;
    }
}
