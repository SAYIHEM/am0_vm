package Operations.AM0.Logical;

import Operations.AM0.Operation;

public class MOD extends Operation {

    public MOD() {

        this.name = "MOD";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x % y);
        increment();
    }
}
