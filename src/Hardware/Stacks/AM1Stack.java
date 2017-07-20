package Hardware.Stacks;

import Constants.Flag;
import OutputHandler.Displayable;

public class AM1Stack extends Stack implements Displayable {

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
}
