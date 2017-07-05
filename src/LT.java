public class LT extends Operation {

    public LT() {

        this.name = "LT";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x < y ? 1 : 0);
        increment();
    }
}
