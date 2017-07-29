package Hardware.Heaps;

import Exceptions.HeapException;
import Exceptions.StackException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class Heap {

    protected final Integer ADDRESS_MAX = 0xFFFF;
    protected Map<Integer, Integer> heap;

    public Heap()
    {
        heap =  new HashMap<>();
    }

    public void store(Integer address, Integer value) throws HeapException {

        if(address < 0 || address >= ADDRESS_MAX)
            throw new HeapException("STORE error. address out of bounds!");
        heap.put(address, value);
    }

    public Integer load(Integer address) throws HeapException {

        if(address < 0 || address >= ADDRESS_MAX)
            throw new HeapException("READ error. address out of bounds! Address was: " + address);

        Integer val = heap.get(address);
        if (val == null) throw new HeapException("READ error. Value in address was NULL! Address was: " + address);

        return val;
    }

    public void emptyFromAddress(int address) {

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
