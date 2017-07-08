package Hardware.Peripherals;

import Hardware.Heaps.Heap;

/**
 * Created by X0R_R0X on 7/8/2017.
 */
public class Display extends Device {

    private int baseAddress, width, height;
    public Display(Heap sharedStorage, int baseAddress, int width, int height) {
        super(sharedStorage);
        this.baseAddress = baseAddress;
        this.height = height;
        this.width = width;
    }

    @Override
    public void update() {

    }

    @Override
    public void reset() {

    }
}
