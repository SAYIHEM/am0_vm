public class SUB extends Operation {

    public SUB() {

        this.name = "SUB";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x - y);
        increment();
    }
}
