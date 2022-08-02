package String;

public class JianzOffer58 {
    class Solution {
        /**
         * 解法1：14：12
         * 原地解法，翻转实现
         * 局部反转+整体反转 达到左旋转
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {
            StringBuilder a = new StringBuilder(s);
            //首先翻转前n个字符
            reverse(a, 0, n - 1);
            //翻转n - length 的字符
            reverse(a, n, s.length() - 1);
            //翻转整个字符串
            a.reverse();
            return a.toString();
        }

        private void reverse(StringBuilder a, int i, int i1) {
            while (i < i1) {
                char temp = a.charAt(i);
                a.setCharAt(i, a.charAt(i1));
                a.setCharAt(i1, temp);
                i ++;
                i1 --;
            }
        }

    }
}
