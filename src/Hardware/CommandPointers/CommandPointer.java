package Hardware.CommandPointers;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class CommandPointer {

    private Integer value;
    public CommandPointer()
    {
        value = 0;
    }

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
