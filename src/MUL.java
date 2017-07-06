public class MUL extends Operation {

    public MUL() {

        this.name = "MUL";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x * y);
        increment();
    }
}
