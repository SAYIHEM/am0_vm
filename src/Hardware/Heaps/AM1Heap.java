package Hardware.Heaps;

import Constants.Flag;
import OutputHandler.Displayable;

import java.util.Map;
import java.util.TreeMap;

public class AM1Heap extends Heap implements Displayable {

    public AM1Heap() {
        super();
    }

    // Copy constructor
    public AM1Heap(AM1Heap heap) {

        if (heap == null) throw new NullPointerException("Heap to copy was NULL!");

        this.heap = new TreeMap<>(heap.getHeap());
    }

    public String getState() {

        if (heap.isEmpty()) return "-";

        StringBuilder actualState = new StringBuilder();

        if (heap.size() == 1) {

            actualState.append((heap.get(1) == null ? Flag.NULL : heap.get(1)));

        } else {

            for (int address : heap.keySet()) {

                actualState.append(heap.get(address) == null ? Flag.NULL : heap.get(address));
                actualState.append(":");
            }
        }

        return actualState.toString();
    }

    public Map<Integer, Integer> getHeap() {

        return this.heap;
    }
}
