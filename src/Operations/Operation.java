package Operations;

public abstract class Operation {

    protected String name;

    public abstract void run(String arg);
    protected abstract void increment();

    public String getName() {

        if (name == null) return "Undefined Operation";

        return name;
    }
}
