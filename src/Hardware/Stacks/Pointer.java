package Hardware.Stacks;


import OutputHandler.Displayable;

public class Pointer implements Displayable {

    private int value;

    public Pointer() {

        this.value = 0;
    }

    public void setValue(int val) {

        this.value = val;
    }

    public void changeValue(int diff) {

        this.value += diff;
    }

    public int getValue() {

        return this.value;
    }

    @Override
    public String getState() {

        return Integer.toString(value);
    }
}
