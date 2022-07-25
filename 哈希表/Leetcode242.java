public class Leetcode242 {
    /**
     * 9minac
     * 解法1 利用哈希表思想，构建一个大小为26的数组。
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            int [] num = new int[26];
            for (int i = 0;i < num.length;i ++) {
                num [i] = 0;
            }
            for (int i = 0;i < s.length();i ++) {
                num[s.charAt(i) - 'a']++;
            }
            for (int i = 0;i < t.length();i ++) {
                num[t.charAt(i) - 'a']--;
                if (num[t.charAt(i) - 'a'] < 0){
                    return false;
                }
            }
            for (int i = 0;i < num.length;i ++) {
                if (num[i] > 0) return false;
            }
            return true;
        }
    }
}
