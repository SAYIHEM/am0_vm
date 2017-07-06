package Operations.AM0.Arithmethic;

import Operations.AM0.Operation;

public class NE extends Operation {

    public NE() {

        this.name = "NE";
    }

    @Override
    public void run(Integer arg) {

        int y = this.runtimeStack.pop();
        int x = this.runtimeStack.pop();

        this.runtimeStack.push(x != y ? 1 : 0);
        increment();
    }
}
