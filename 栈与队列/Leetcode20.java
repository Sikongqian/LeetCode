package StackQueue;


import java.util.Deque;
import java.util.LinkedList;

public class Leetcode20 {
    class Solution {
        /**
         * 解法1：15分钟ac
         * 栈解法
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            Deque<Character> a = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                if (a.peek() == null) {
                    a.push(s.charAt(i));
                    continue;
                }
                if (a.peek() == '(' && s.charAt(i) == ')') {
                    a.pop();
                }else if (a.peek() == '[' && s.charAt(i) == ']') {
                    a.pop();
                }else if (a.peek() == '{' && s.charAt(i) == '}') {
                    a.pop();
                }else {
                    a.push(s.charAt(i));
                }
            }
            if (a.isEmpty()) return true;
            else return false;
        }

        /**
         * 解法2：
         * 做push时可以将对应右括号push进去，这样判断时方便些
         * 右括号直接看是否匹配就行
         * 做一些剪枝
         * @param s
         * @return
         */
        public boolean isValid2(String s) {
            Deque<Character> deque = new LinkedList<>();
            char ch;
            for (int i = 0; i < s.length(); i++) {
                ch = s.charAt(i);
                //碰到左括号，就把相应的右括号入栈
                if (ch == '(') {
                    deque.push(')');
                }else if (ch == '{') {
                    deque.push('}');
                }else if (ch == '[') {
                    deque.push(']');
                } else if (deque.isEmpty() || deque.peek() != ch) {
                    return false;
                }else {//如果是右括号判断是否和栈顶元素匹配
                    deque.pop();
                }
            }
            //最后判断栈中元素是否匹配
            return deque.isEmpty();
        }
    }
}
