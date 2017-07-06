public class EQ extends Operation {

    public EQ() {

        this.name = "EQ";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x == y ? 1 : 0);

        increment();
    }
}
