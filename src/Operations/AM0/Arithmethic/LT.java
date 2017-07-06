package Operations.AM0.Arithmethic;

import Operations.AM0.Operation;

public class LT extends Operation {

    public LT() {

        this.name = "LT";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x < y ? 1 : 0);
        increment();
    }
}