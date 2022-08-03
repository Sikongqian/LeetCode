package StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode225 {
    /**
     * 解法1： 14min ac
     * 其实一个队列就够
     */
    class MyStack {
        Deque<Integer> myQueue;

        Deque<Integer> myQueue1;

        public MyStack() {
            myQueue = new ArrayDeque();
            myQueue1 = new ArrayDeque();
        }

        public void push(int x) {
            while (!myQueue.isEmpty()) {
                myQueue1.offer(myQueue.poll());

            }
            myQueue.offer(x);
        }

        public int pop() {
            int res = myQueue.poll();
            int size = myQueue1.size();
            for (int i = 0; i < size; i++) {
                this.push(myQueue1.poll());
            }
            return res;
        }

        public int top() {
            int res = myQueue.poll();
            this.push(res);
            return res;
        }

        public boolean empty() {
            if (myQueue.isEmpty() && myQueue1.isEmpty()) return true;
            else return false;
        }
    }
}
