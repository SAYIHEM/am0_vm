import java.util.ArrayList;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class Stack {
    private static Stack instance = new Stack();
    public Stack getInstance()
    {
        return instance;
    }

    private ArrayList<Integer> stack = new ArrayList<>();

    //throws StackExceptions
    public Integer pop()
    {
        int i = stack.size() - 1;
        if(i < 0)
        {
            throw new StackException("negative stackpointer! stack empty.");
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
