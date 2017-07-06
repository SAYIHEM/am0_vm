public class DIV extends Operation {

    public DIV() {

        this.name = "DIV";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x / y);

        increment();
    }
}
