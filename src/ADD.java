public class ADD extends Operation {

    public ADD() {

        this.name = "ADD";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x + y);

        increment();
    }

}
