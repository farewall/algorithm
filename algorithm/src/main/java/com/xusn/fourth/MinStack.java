package com.xusn.fourth;

import java.util.Stack;

/**
 * ��Сջ
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();

    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty() || minStack.peek() > val) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}