package Hardware.Stacks;


public class Pointer {

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
}
