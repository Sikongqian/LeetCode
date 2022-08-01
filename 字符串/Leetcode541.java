package String;

public class Leetcode541 {
    /**
     * 解法1：先找到每段起点start 然后根据不同情况进行操作
     * 其实没必要再设一个stringbuffer来进行操作
     */
    class Solution {
        public String reverseStr(String s, int k) {
            StringBuffer s1 = new StringBuffer();
            int length = s.length();
            int start = 0;
            int end = k - 1;
            while (start < length - 1) {
                if (end < length - 1) {
                    while (end > start) {
                        s1.append(s.charAt(end));
                        end --;
                    }
                }else {
                    end = length - 1;
                    while (end > start) {
                        s1.append(s.charAt(end));
                        end --;
                    }
                    break;
                }
                end = start + (k - 1);
                while (end < length - 1 && end < start + (2 * k)) {
                    s1.append(s.charAt(end));
                    end ++;
                }
                start += (2 * k);
                end = start + (k - 1);
            }
            return s1.toString();
        }
    }

    /**
     * 解法2：使用tochararray
     * 注意，返回时返回new String(chArr) 不要返回 chARR.TOSTRING
     */
    class solution2 {
        public String reverseStr(String s, int k) {
            char [] s1 = s.toCharArray();
            for (int i = 0;i < s1.length;i += 2*k) {
                if (i + k - 1 < s1.length - 1) reverse(s1, i, i + k - 1);
                else reverse(s1, i, s1.length - 1);
            }
            return  s1.toString();
         }
         public void reverse (char[] s1, int i, int j) {
            while (i <= j) {
                s1[i] ^= s1[j];
                s1[j] ^= s1[i];
                s1[i] ^= s1[j];
            }
         }
    }
}
