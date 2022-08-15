package StackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode150 {
    class Solution {
        /**
         * 解法1：23分钟ac
         * 树的遍历，利用堆栈
         * 注意字符串转化未数字的方式
         * @param tokens
         * @return
         */
        public int evalRPN(String[] tokens) {
            Deque<Integer> a = new LinkedList<>();
            for (int i = 0; i < tokens.length; i ++) {
                if (tokens[i].length() == 1 && (tokens[i].charAt(0) == '*' ||
                                                tokens[i].charAt(0) == '-' ||
                                                tokens[i].charAt(0) == '+' ||
                                                tokens[i].charAt(0) == '/' )){
                    int operator1 = a.pop();
                    int operator2 = a.pop();
                    switch (tokens[i].charAt(0)) {
                        case '*':
                            a.push(operator1 * operator2);
                            break;
                        case '/':
                            a.push(operator1 / operator2);
                            break;
                        case '+':
                            a.push(operator1 + operator2);
                            break;
                        case '-':
                            a.push(operator1 - operator2);
                            break;
                    }

                }else {
                    int temp = Integer.valueOf(tokens[i]);
                    a.push(temp);
                }
            }
            return a.pop();
        }
    }
}
