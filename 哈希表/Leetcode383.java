public class Leetcode383 {
    class Solution {
        /**
         * 解法1：6分钟ac
         * 就26大小的数组存储就行
         * @param ransomNote
         * @param magazine
         * @return
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] letFre = new int[26];
            for (int i = 0;i < ransomNote.length();i ++) {
                letFre[ransomNote.charAt(i) - 'a']++;
            }
            for (int i = 0;i < magazine.length();i ++) {
                letFre[magazine.charAt(i) - 'a']--;
            }
            for (int i = 0;i < 26;i ++) {
                if (letFre[i] > 0) return false;
            }
            return true;
        }
    }
}
