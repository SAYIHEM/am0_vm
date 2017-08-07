package Hardware.Stacks;

import Constants.Flag;
import Exceptions.StackException;
import OutputHandler.Displayable;

import java.util.ArrayList;

public class Stack implements Displayable {

    protected ArrayList<Integer> stack;

    // Constructor
    public Stack() { stack = new ArrayList<>(); }

    //throws StackExceptions
    public Integer pop() throws StackException {

        int i = stack.size() - 1;
        if(i < 0)
        {
            throw new StackException("Negative StackPointer! RuntimeStack empty.");
        }
        Integer value = stack.get(i);
        stack.remove(i);
        return value;
    }

    public void push(Integer integer) {

        stack.add(integer);
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
}
