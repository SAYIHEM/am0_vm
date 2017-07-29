package Hardware.Peripherals;

import Exceptions.HeapException;
import Hardware.Heaps.Heap;

/**
 * Created by X0R_R0X on 7/8/2017.
 */
public abstract class Device {
    protected Heap sharedStorage;
    public Device(Heap sharedStorage)
    {
        this.sharedStorage = sharedStorage;
    }

    public abstract void update() throws HeapException;
    public abstract void reset() throws HeapException;
}
