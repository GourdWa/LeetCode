package com.learn.domain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZixiangHu
 * @create 2020-05-12  14:20
 * @description
 */
class MinStack {
    private Deque<Integer> stack1 = new LinkedList<>();

    private Deque<Integer> stack2 = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek())
            stack2.push(x);
    }

    public void pop() {
        //注意这里一定要使用equals，因为元素类型是Integer，不能直接使用==
        if (stack1.peek().equals(stack2.peek()))
            stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

public class MiniStackTest {
    public static void main(String[] args) {
        MinStack miniStack = new MinStack();
        miniStack.push(512);
        miniStack.push(-1024);
        miniStack.push(-1024);
        miniStack.push(512);

        miniStack.pop();
        System.out.println(miniStack.getMin());
        miniStack.pop();
        System.out.println(miniStack.getMin());
        miniStack.pop();
        System.out.println(miniStack.getMin());
    }
}
