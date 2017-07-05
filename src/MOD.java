public class MOD extends Operation {

    public MOD() {

        this.name = "MOD";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x % y);
        increment();
    }
}
