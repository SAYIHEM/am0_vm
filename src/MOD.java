public class MOD extends Operation {

    public MOD() {

        this.name = "MOD";
    }

    @Override
    public void run(String arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x % y);
    }
}
