package Hardware.Stacks;

import Constants.Flag;
import OutputHandler.Displayable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AM1Stack extends Stack implements Displayable {

    public AM1Stack() {
        super();
    }

    // Copy constructor
    public AM1Stack(AM1Stack stack) {

        if (stack == null) throw new NullPointerException("Stack to copy was NULL!");

        this.stack = new ArrayList<>(stack.getStack());

    }

    @Override
    public String getState() {

        if (stack.isEmpty()) return "-";

        StringBuilder actualState = new StringBuilder();

        if (stack.size() == 1) {

            actualState.append((stack.get(0) == null ? Flag.NULL : stack.get(0)));

        } else {

            for (int value : stack) {

                actualState.append(stack.get(value) == null ? Flag.NULL : stack.get(value));
                actualState.append(":");
            }
        }

        return actualState.toString();
    }

    public List<Integer> getStack() {

        return this.stack;
    }
}
