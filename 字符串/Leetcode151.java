package String;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode151 {
    class Solution {
        /**
         * 解法1： 32min ac
         * 似乎可以直接从后往前找，用一个stringbuffer来存储
         * （思路不是很清晰的话，代码实现就会遇到许多边界问题）
         * @param s
         * @return
         */
        public String reverseWords(String s) {
            StringBuffer res = new StringBuffer();
            int start = s.length() - 1;
            int end = s.length() - 1;
            for (int i = s.length() - 1;i >= 0;i --) {
                if (s.charAt(i) != ' ') {
                    start = i;
                }else {
                    //此时将start和end中的内容加到res中，同时start和end的位置初始化为i
                    int tempStart = start;
                    if (s.charAt(tempStart) != ' ') {
                        while (tempStart <= end) {
                            res.append(s.charAt(tempStart));
                            tempStart++;
                        }
                        res.append(' ');
                    }
                    start = i;
                    end = i;
                }
            }
            if (s.charAt(start) != ' ') {
                while (start <= end) {
                    res.append(s.charAt(start));
                    start++;
                }
            }
            return res.toString();
        }


        /**
         * 移除空格 + 双反转
         * 复杂问题可以分多步完成
         * @param s
         * @return
         */
        public String reverseWords2(String s) {
            // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
            // 1.去除首尾以及中间多余空格
            StringBuilder sb = removeSpace(s);
            // 2.反转整个字符串
            reverseString(sb, 0, sb.length() - 1);
            // 3.反转各个单词
            reverseEachWord(sb);
            return sb.toString();
        }

        private StringBuilder removeSpace(String s) {
            // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
            int start = 0;
            int end = s.length() - 1;
            //先消去前后的空格
            while (s.charAt(start) == ' ') start++;
            while (s.charAt(end) == ' ') end--;
            StringBuilder sb = new StringBuilder();
            while (start <= end) {
                char c = s.charAt(start);
                if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }
                start++;
            }
            // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
            return sb;
        }

        /**
         * 反转字符串指定区间[start, end]的字符
         */
        public void reverseString(StringBuilder sb, int start, int end) {
            // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
            // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
        }

        private void reverseEachWord(StringBuilder sb) {
            int start = 0;
            int end = 1;
            int n = sb.length();
            while (start < n) {
                while (end < n && sb.charAt(end) != ' ') {
                    end++;
                }
                reverseString(sb, start, end - 1);
                start = end + 1;
                end = start + 1;
            }
        }
    }
    }
}
