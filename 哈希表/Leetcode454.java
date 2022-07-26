import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode454 {
    class Solution {
        /**
         * 解法1：22分钟ac
         * 和两数之和很像，一个n方的解法
         * 先合并两个数组1，2 和3，4 n方
         * 再用两数之和解法 n方
         *
         * 该解法和代码随想录的标准解法思路相同，不同的时，标准答案做了优化
         * 不需要用整个数组存储归并结果，直接循环遍历就行
         * @param nums1
         * @param nums2
         * @param nums3
         * @param nums4
         * @return
         */
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            //merge
            int [] num12 = new int[nums1.length * nums1.length];
            int [] num34 = new int[nums3.length * nums3.length];
            int cnt = 0;
            for (int i: nums1) {
                for (int j: nums2) {
                    num12[cnt] = i + j;
                    cnt ++;
                }
            }
            cnt = 0;
            for (int i: nums3) {
                for (int j: nums4) {
                    num34[cnt] = i + j;
                    cnt ++;
                }
            }

            //judge
            int num = 0;
            Map<Integer, Integer> temp = new HashMap<>();
            for (int i: num34) {
                if (temp.containsKey(i)) {
                    temp.replace(i, temp.get(i) + 1);
                }else {
                    temp.put(i, 1);
                }
            }
            for (int i: num12) {
                if (temp.containsKey(0 - i)) {
                    num += temp.get(0 - i);
                }
            }
            return num;
        }

        /**
         * 代码随想录解法
         */
        public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            int temp;
            int res = 0;
            //统计两个数组中的元素之和，同时统计出现的次数，放入map
            for (int i : nums1) {
                for (int j : nums2) {
                    temp = i + j;
                    if (map.containsKey(temp)) {
                        map.put(temp, map.get(temp) + 1);
                    } else {
                        map.put(temp, 1);
                    }
                }
            }
            //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
            for (int i : nums3) {
                for (int j : nums4) {
                    temp = i + j;
                    if (map.containsKey(0 - temp)) {
                        res += map.get(0 - temp);
                    }
                }
            }
            return res;
        }
    }
}
