package datastructure;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    Deque<Integer> inputStack;
    Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new LinkedList<>();
        outputStack = new LinkedList<>();
    }

    public void push(int x) {
        inputStack.offer(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.offer(inputStack.poll());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.offer(inputStack.poll());
            }
        }
        if (outputStack.isEmpty()) {
            return 0;
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
