package String;

public class leetcode28 {
    class Solution {
        /**
         * 解法1：滑动窗口，24分钟ac
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if (haystack.length() < needle.length()) return -1;
            if (needle == null) return 0;
            int res = -1;
            int start = 0;
            int end = 0;
            int start2 = 0;
            while (end < haystack.length() && start2 < needle.length()) {
                if (haystack.charAt(end) == needle.charAt(start2)) {
                    start2 ++;
                    end ++;
                }else {
                    start2 = 0;
                    start ++;
                    end = start;
                }
            }
            if (start2 == needle.length()) res = start;
            return res;
        }

        /**
         * 解法2:kmp算法
         * 1. 构建前缀表
         * 2. 遍历匹配
         * 主要是模式匹配的思想，和前缀表的应用
         * 后缀可以用作下一个前缀的匹配
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr2(String haystack, String needle) {
            if (needle == null) return 0;
            int [] next = new int[needle.length()];
            getNext(next, needle);
            int j = 0;
            for (int i = 0;i < haystack.length();i ++) {
                while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                    j = next[j - 1];
                if (needle.charAt(j) == haystack.charAt(i)) j ++;
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }

        public void getNext (int [] next, String needle) {
            next[0] = 0;
            int j = 0;
            for (int i = 1;i < needle.length();i ++) {
                while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                    j = next[j - 1];
                }
                if (needle.charAt(j) == needle.charAt(i)) j++;
                next[i] = j;
            }
        }
    }
}
