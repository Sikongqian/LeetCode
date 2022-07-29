import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    /**
     * 血的教训，注意测试用例长度，千万不能爆int
     */
    /**
     * 解法1：1小时15分钟
     * 主要思路不变，就是在三数之和的基础上再加一层循环
     */
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            //第一个数的下标
            int i = 0;
            //第二个数的下标
            int j = 0;
            //第三个数的下标
            int left = 0;
            //第四个数的下标
            int right = 0;
            //排序
            Arrays.sort(nums);
            //第一层循环 (需去重)
            for (i = 0;i < nums.length;i ++) {
                if ((long)4 * nums[i] > target) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                //第二层循环 (需去重)
                for (j = i + 1;j < nums.length;j ++){
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    left = j + 1;
                    right = nums.length - 1;
                    //确定第三四个数
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum > target) {
                            right --;
                        }else if (sum < target) {
                            left ++;
                        }else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            right --;
                            left ++;
                            while (left < right && nums[right] == nums[right + 1]) right --;
                            while (left < right && nums[left] == nums[left - 1]) left ++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
