package com.xusn.third;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        shift();
        return outStack.pop();
    }

    public int peek() {
        shift();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    private void shift() {
        if (outStack.empty()) {
           while (!inStack.empty()) {
               outStack.push(inStack.pop());
           }
        }
    }
}
