package InstructionSets;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Hardware.Stacks.Pointer;
import Hardware.Stacks.Stack;
import Operations.AM0.Arithmethic.*;
import Operations.AM0.Logical.*;
import Operations.AM0.Memory.JMC;
import Operations.AM0.Memory.JMP;
import Operations.AM0.Memory.LIT;
import Operations.AM1.FunctionCommands.CALL;
import Operations.AM1.FunctionCommands.PUSH;
import Operations.AM1.FunctionCommands.RET;
import Operations.AM1.Memory.*;
import Operations.Operation;

import java.util.Map;

public class AM1Instructions extends Instructions {

    public AM1Instructions(Heap heap, Stack stack, CommandPointer commandPointer, Pointer reference) {

        // SetUp Operation-Map for AM1
        instructions.put("ADD", new ADD(heap, stack, commandPointer));
        instructions.put("MUL", new MUL(heap, stack, commandPointer));
        instructions.put("SUB", new SUB(heap, stack, commandPointer));
        instructions.put("DIV", new DIV(heap, stack, commandPointer));
        instructions.put("MOD", new MOD(heap, stack, commandPointer));

        instructions.put("EQ", new EQ(heap, stack, commandPointer));
        instructions.put("NE", new NE(heap, stack, commandPointer));
        instructions.put("LT", new LT(heap, stack, commandPointer));
        instructions.put("GT", new GT(heap, stack, commandPointer));
        instructions.put("LE", new LE(heap, stack, commandPointer));
        instructions.put("GE", new GE(heap, stack, commandPointer));

        instructions.put("JMP", new JMP(heap, stack, commandPointer));
        instructions.put("JMC", new JMC(heap, stack, commandPointer));
        instructions.put("LIT", new LIT(heap, stack, commandPointer));

        // AM1-specific Operations
        instructions.put("LOAD", new LOAD(heap, stack, commandPointer, reference));
        instructions.put("WRITE", new WRITE(heap, stack, commandPointer, reference));
        instructions.put("LOADI", new LOADI(heap, stack, commandPointer, reference));
        instructions.put("WRITEI", new WRITEI(heap, stack, commandPointer, reference));
        instructions.put("LOADA", new LOADA(heap, stack, commandPointer, reference));
        instructions.put("STORE", new STORE(heap, stack, commandPointer, reference));
        instructions.put("READ", new READ(heap, stack, commandPointer, reference));
        instructions.put("STOREI", new STOREI(heap, stack, commandPointer, reference));
        instructions.put("READI", new READI(heap, stack, commandPointer, reference));
        instructions.put("PUSH", new PUSH(heap, stack, commandPointer, reference));
        instructions.put("CALL", new CALL(heap, stack, commandPointer, reference));
        instructions.put("INIT", new INIT(heap, stack, commandPointer, reference));
        instructions.put("RET", new RET(heap, stack, commandPointer, reference));
    }

    @Override
    public Map<String, Operation> getInstructions() {

        return instructions;
    }
}
