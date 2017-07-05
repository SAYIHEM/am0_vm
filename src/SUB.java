public class SUB extends Operation {

    public SUB() {

        this.name = "SUB";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x - y);
    }
}
