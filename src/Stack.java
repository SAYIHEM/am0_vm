import java.util.ArrayList;

public class Stack {

    // Stack instances
    protected static Stack runtimeStack = null;
    protected static Stack dataStack = null;

    private ArrayList<Integer> stack;

    // Constructor
    private Stack() { stack = new ArrayList<>(); }


    public static Stack getRuntimeStack() {

        if (runtimeStack == null) runtimeStack = new Stack();

        return runtimeStack;
    }

    public static Stack getDataStack() {

        if (dataStack == null) dataStack = new Stack();

        return dataStack;
    }

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
