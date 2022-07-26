import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    class Solution {
        /**
         * 解法1：20min ac
         * 先把互补元素全部放到集合里，然后遍历数组看是否包含
         * 有点麻烦了，可以在第一次遍历时就搞定全部
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> temp = new HashMap<>();
            for (int i = 0;i < nums.length;i ++) {
                temp.put(target - nums[i], i);
            }
            int [] res = new int[2];
            for (int i = 0;i < nums.length;i ++) {
                if (temp.containsKey(nums[i])) {
                    res[0] = i;
                    res[1] = temp.get(nums[i]);
                    if (res[0] != res[1]) break;
                    else {
                        res[0] = 0;
                        res[1] = 0;
                    }
                }
            }
            return res;
        }

        public int[] twoSum2(int[] nums, int target) {
            int [] res = new int[2];

            Map<Integer,Integer> temp = new HashMap<>();
            for (int i = 0;i < nums.length;i ++) {
                if (temp.containsKey(nums[i]) && i != temp.get(nums[i])) {
                    res[0] = i;
                    res[1] = temp.get(nums[i]);
                    break;
                }
                temp.put(target - nums[i], i);
            }
            return res;
        }
    }
}
