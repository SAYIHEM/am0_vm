public class MUL extends Operation {

    public MUL() {

        this.name = "MUL";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x * y);
    }
}
