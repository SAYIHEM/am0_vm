package Operations.AM0.Logical;

import Operations.AM0.Operation;

public class SUB extends Operation {

    public SUB() {

        this.name = "Operations.AM0.Logical.SUB";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x - y);
        increment();
    }
}
