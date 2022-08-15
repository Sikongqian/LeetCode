package StackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode239 {
    class Solution {
        /**
         * 解法1：45min ac
         * a在b 的后面，a还比b大，那么b就可以被省略。
         * 使用队列 + 栈的形式，队列来清除过去的值，栈来排除不合格的值，
         * 最大值一直在头部
         * 时间复杂度O(n)
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<util> a  = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                while (!a.isEmpty() && a.getLast().num < nums[i]) {
                    a.removeLast();
                }
                a.addLast(new util(nums[i], i));
            }
            int []res = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length - k; i++) {
                res[i] = a.peek().num;
                while (!a.isEmpty() && a.getLast().num < nums[i + k]) {
                    a.removeLast();
                }
                a.addLast(new util(nums[i + k], i + k));
                if (a.getFirst().pos <= i) a.removeFirst();
            }
            res[nums.length - k] = a.getFirst().num;
            return res;
        }

    }
    public class util {
        public int num;
        public int pos;
        public util(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }
    }

    /**
     * 解法2：其实和我的解法一样
     * 不过这里给这种数据结构起了一个名字叫做单调队列：保证队列里的元素单调增or减
     */
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.poll();
            }
        }
        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }
        //队列队顶元素始终为最大值
        int peek() {
            return deque.peek();
        }
    }


}
