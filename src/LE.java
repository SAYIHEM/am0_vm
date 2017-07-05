public class LE extends Operation {

    public LE() {

        this.name = "LE";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x <= y ? 1 : 0);

        increment();
    }
}
