package Operations;

import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;

public abstract class Operation {

    protected String name;

    public abstract void run(String arg) throws InvalidOperationArgumentException, HeapException, StackException;
    protected abstract void increment();

    public String getName() {

        if (name == null) return "Undefined Operation";

        return name;
    }
}
