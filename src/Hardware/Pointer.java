package Hardware;


import OutputHandler.Displayable;

public class Pointer implements Displayable {

    private int value;

    // Copy constructor
    public Pointer(Pointer pointer) {

        if (pointer == null) throw new NullPointerException("Pointer to copy was NULL!");

        this.value = pointer.getValue();
    }

    public Pointer() {

        this.value = 0;
    }

    public void setValue(int val) {

        this.value = val;
    }

    public int getValue() {

        return this.value;
    }

    @Override
    public String getState() {

        return Integer.toString(value);
    }
}
