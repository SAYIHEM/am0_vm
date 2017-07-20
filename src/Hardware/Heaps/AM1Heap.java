package Hardware.Heaps;

import Constants.Flag;
import OutputHandler.Displayable;

public class AM1Heap extends Heap implements Displayable {

    public String getState()  {

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
}
