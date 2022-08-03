package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode232 {
    /**
     * 5分钟ac，很经典
     */
    class MyQueue {
        //暂存区
        Deque<Integer> myStack;

        //处理区
        Deque<Integer> myStack1;

        public MyQueue() {
            myStack = new ArrayDeque<>();
            myStack1 = new ArrayDeque<>();
        }

        public void push(int x) {
            myStack.push(x);
        }

        public int pop() {
            if (myStack1.isEmpty()) {
                while (! myStack.isEmpty()) {
                    int temp = myStack.pop();
                    myStack1.push(temp);
                }
            }
            return myStack1.pop();
        }

        public int peek() {
            int res = myStack1.pop();
            myStack1.push(res);
            return res;
        }

        public boolean empty() {
            if(myStack1.isEmpty() && myStack.isEmpty()) {
                return true;
            }else {
                return false;
            }
        }
    }
}
