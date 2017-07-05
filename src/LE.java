public class LE extends Command {

    public LE() {

        this.name = "LE";
    }

    @Override
    public void run(String arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x <= y ? 1 : 0);
    }
}
