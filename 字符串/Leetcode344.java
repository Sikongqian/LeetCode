package String;

public class Leetcode344 {
    /**
     * 解法1：13:46 5分钟ac
     * ^是一种位运算符表示按位异或 可以用来交换数值 因为
     * a^b^b=a b^a^a=b
     * 前后双指针
     */
    class Solution {
        public void reverseString(char[] s) {
            if (s == null) return;
            int ptr1 = 0;
            int ptr2 = s.length - 1;
            char temp = 0;
            while (ptr1 < ptr2) {
                temp = s[ptr1];
                s[ptr1] = s[ptr2];
                s[ptr2] = temp;
                ptr1 ++;
                ptr2 --;
            }
            return;
        }
    }
}
