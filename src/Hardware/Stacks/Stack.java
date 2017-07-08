package Stacks;

import Exceptions.StackException;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stack;

    // Constructor
    public Stack() { stack = new ArrayList<>(); }

    //throws StackExceptions
    public Integer pop()
    {
        int i = stack.size() - 1;
        if(i < 0)
        {
            throw new StackException("negative stackpointer! runtimeStack empty.");
        }
        Integer value = stack.get(i);
        stack.remove(i);
        return value;
    }

    public void push(Integer integer)
    {
        stack.add(integer);
    }
}
