package String;

public class Leetcode459 {
    class Solution {
        /**
         * 解法1：32分钟ac 不过不清不楚，过的很蹊跷
         * 似乎可以用前缀后缀法
         * 先找到最大前后缀，子字符串如果有的话必然是这个
         * @param s
         * @return
         */
        public boolean repeatedSubstringPattern(String s) {
            int [] next = new int[s.length()];
            next[0] = 0;
            int j = 0;
            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) j ++;
                next[i] = j;
            }
            int num = next[s.length() - 1];
            if (num == 0) return false;
            if (s.length() - num == 1) return true;
            for (int i = num; i < s.length(); i ++) {
                if (s.charAt(i) != s.charAt(i%num)) return false;
            }
            return true;
        }

        /**
         * 解法2：答案解法，
         * 主要是根据前缀表的性质来解答的这个问题
         */
        public boolean repeatedSubstringPattern2(String s) {
            if (s.equals("")) return false;

            int len = s.length();
            // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
            s = " " + s;
            char[] chars = s.toCharArray();
            int[] next = new int[len + 1];

            // 构造 next 数组过程，j从0开始(空格)，i从2开始
            for (int i = 2, j = 0; i <= len; i++) {
                // 匹配不成功，j回到前一位置 next 数组所对应的值
                while (j > 0 && chars[i] != chars[j + 1]) j = next[j];
                // 匹配成功，j往后移
                if (chars[i] == chars[j + 1]) j++;
                // 更新 next 数组的值
                next[i] = j;
            }

            // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
            if (next[len] > 0 && len % (len - next[len]) == 0) {
                return true;
            }
            return false;
        }
    }
}
