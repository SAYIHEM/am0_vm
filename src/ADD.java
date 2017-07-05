public class ADD extends Command {

    public ADD() {

        super();
        this.name = "ADD";
    }

    @Override
    public void run(String arg) {

        /*if (arg.isEmpty() || arg.length() > 3) {
            throw new IllegalArgumentException("Wrong Argument for " + this.name + " Arg:" + arg);
        }*/

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x + y);
    }

}
