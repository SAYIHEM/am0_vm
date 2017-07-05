public class GE extends Operation {

    public GE() {

        this.name = "GE";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x >= y ? 1 : 0);

        increment();
    }
}
