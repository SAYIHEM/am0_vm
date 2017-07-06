import java.util.ArrayList;

public abstract class Stack {

    protected static Stack instance = null;
    protected ArrayList<Integer> stack = new ArrayList<>();


    public static Stack getInstance()
    {
        if (instance == null) throw new UnsupportedOperationException("Abstract class Stack cannot be instantiated!");

        return instance;
    }

    public abstract Integer pop();
    public abstract void push(Integer integer);
}
