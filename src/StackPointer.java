/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class StackPointer {
    private static StackPointer instance = new StackPointer();
    public static StackPointer getInstance()
    {
        return instance;
    }
    private Integer value = 0;
    public void increment()
    {
        value += 1;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public Integer getValue()
    {
        return value;
    }
}
