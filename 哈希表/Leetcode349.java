import java.util.HashSet;
import java.util.Set;

public class Leetcode349 {
    class Solution {
        /**
         * 解法1：13分钟ac
         * 要算交集
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            Set<Integer> temp = new HashSet<>();
            Set<Integer> result = new HashSet<>();

            for (int i = 0;i < len1;i ++) {
                temp.add(nums1[i]);
            }
            for (int i = 0;i < len2;i ++) {
                if (temp.contains(nums2[i]) && ! result.contains(nums2[i]))
                    result.add(nums2[i]);
            }
            int[] resultArray = new int[result.size()];
            int cnt = 0;
            for (Integer i : result) {
                resultArray[cnt] = i;
                cnt ++;
            }
            return resultArray;
        }

        /**
         * 代码随想录中的解法思路一致，一些技巧可以借鉴
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection2(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[0];
            }
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> resSet = new HashSet<>();
            //遍历数组用 for each
            for (int i : nums1) {
                set1.add(i);
            }

            for (int i : nums2) {
                if (set1.contains(i)) {
                    resSet.add(i);
                }
            }

            // 将结果转换为数组，不过似乎有toarray方法
            return resSet.stream().mapToInt(x -> x).toArray();
        }


    }
}
