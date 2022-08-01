package String;

public class JianzOffer05 {
    /**
     * 解法1：5minac
     * 想要做到极致，不能用额外的空间，由于java String类的特性，这是做不到的
     */
    class Solution {
        public String replaceSpace(String s) {
            StringBuffer s1 = new StringBuffer();
            for (int i = 0;i < s.length();i ++) {
                if (s.charAt(i) == ' ') {
                    s1.append("%20");
                }else {
                    s1.append(s.charAt(i));
                }
            }
            return s1.toString();
        }
    }
}
