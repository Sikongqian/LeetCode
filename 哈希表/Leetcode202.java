import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    class Solution {
        /**
         * 解法1：33分钟ac 发呆了一会。。
         * 思路，用哈希集合存放数据，发生循环退出循环，看最后是否为1
         * @param n
         * @return
         */
        public boolean isHappy(int n) {
            Set<Integer> temp = new HashSet<>();
            while (! temp.contains(n)) {
                temp.add(n);
                n = addSqrt(n);
            }
            if (n == 1) return true;
            return false;
        }

        int addSqrt (int n) {
            int sum = 0;
            int temp = 0;
            while (n != 0) {
                temp = n % 10;
                n = n / 10;
                sum += (temp*temp);
            }
            return sum;
        }
    }
}
