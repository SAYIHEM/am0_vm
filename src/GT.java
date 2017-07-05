public class GT extends Operation {

    public GT() {

        this.name = "GT";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x > y ? 1 : 0);

        increment();
    }
}
