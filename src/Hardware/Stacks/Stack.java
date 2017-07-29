package Hardware.Stacks;

import Exceptions.StackException;

import java.util.ArrayList;

public class Stack {

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
}
