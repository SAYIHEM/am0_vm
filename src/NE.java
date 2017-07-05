public class NE extends Operation {

    public NE() {

        this.name = "NE";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x != y ? 1 : 0);
        increment();
    }
}
