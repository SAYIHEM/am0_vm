public class DIV extends Operation {

    public DIV() {

        this.name = "DIV";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x / y);

        increment();
    }
}
