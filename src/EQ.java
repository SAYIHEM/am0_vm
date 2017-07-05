public class EQ extends Operation {

    public EQ() {

        this.name = "EQ";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x == y ? 1 : 0);

        increment();
    }
}
