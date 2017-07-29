package Hardware.CommandPointers;

import OutputHandler.Displayable;

/**
 * Created by X0R_R0X on 7/5/2017.
 */
public class CommandPointer implements Displayable {

    private Integer value;

    public CommandPointer()
    {
        value = 0;
    }

    // Copy constructor
    public CommandPointer(CommandPointer commandPointer) {

        if (commandPointer == null) throw new NullPointerException("CommandPointer to copy was NULL!");

        this.value = commandPointer.getValue();
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

    @Override
    public String getState() {

        return Integer.toString(this.value);
    }
}
