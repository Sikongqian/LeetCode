package StackQueue;

public class Leetcode1047 {
    class Solution {
        /**
         * 解法1：5min ac
         * 很经典的栈问题
         * @param s
         * @return
         */
        public String removeDuplicates(String s) {
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 || a.charAt(a.length() - 1) == s.charAt(i)) {
                    a.deleteCharAt(a.length() - 1);
                }else {
                    a.append(s.charAt(i));
                }
            }

            return a.toString();
        }

        /**
         * 解法2：双指针解法 fast and slow
         */
        public String removeDuplicates2(String s) {
            char[] ch = s.toCharArray();
            int fast = 0;
            int slow = 0;
            while(fast < s.length()){
                // 直接用fast指针覆盖slow指针的值
                ch[slow] = ch[fast];
                // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
                if(slow > 0 && ch[slow] == ch[slow - 1]){
                    slow--;
                }else{
                    slow++;
                }
                fast++;
            }
            return new String(ch,0,slow);
        }
    }
}
