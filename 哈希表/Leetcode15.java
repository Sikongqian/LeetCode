import java.lang.reflect.Array;
import java.util.*;

public class Leetcode15 {
    class Solution {
        /**
         * 此题介绍 Arrays 叔祖方法类的介绍
         * 需要注意的是，这题的三指针法和排序去重方法值得一看
         */
        /**
         * 解法1：14：37
         * 哈希法
         * 首先先找两数之和，然后看第三个数是否互补
         * 需要找到元组，那么 键：两数之和 值：值的集合
         * 注意不能包含重复的三元组，那么需要保证二元组不重复，且找互补的时候不能
         * 找相同的值
         * (想得不完善，还是没过，去重没有搞定)
         * (代码随想录去重是用)
         * @param nums
         * @return
         */
        public List<List<Integer>> threeSum(int[] nums) {
            //找两数之和，键：两数之和 值：较小的那个数的集合，用哈希集合存储
            Map<Integer, HashSet<Integer>> twoSum = new HashMap<>();
            //循环找
            for (int i = 0;i < nums.length;i ++) {
                for (int j = i + 1;j < nums.length;j ++)  {
                    //此时判断i和j谁小，谁小储存谁
                    int tempInt = 0;
                    if (nums[i] < nums[j]) {
                        tempInt = nums[i];
                    }else {
                        tempInt = nums[j];
                    }
                    //把这个较小数存储到集合里去
                    //首先判断hashmap里面是否有
                    if (twoSum.containsKey(nums[i] + nums[j])) {
                        if(! twoSum.get(nums[i] + nums[j]).contains(tempInt))
                            twoSum.get(nums[i] + nums[j]).add(tempInt);
                    }else {
                        twoSum.put(nums[i] + nums[j], new HashSet<>());
                        twoSum.get(nums[i] + nums[j]).add(tempInt);
                    }
                }
            }
            List<List<Integer>> res = new ArrayList<>();
            //找第三个数，此时需要注意，第三个数也不能相同，可以用匹配到一个就减一个的思想
            for (int i: nums) {
                if (twoSum.containsKey(- i)) {
                    //加到res里，删掉twoSum里的元素
                    for (int j: twoSum.get(- i)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        temp.add(0 - i - j);
                        res.add(temp);
                    }
                    twoSum.remove(- i);
                }
            }
            return res;
        }


    }

    /**
     * 三指针法，很巧妙
     * 重点是先排序，之后就好进行去重操作
     */
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            //开始循环，最外层是最靠前的指针
            for (int i = 0;i < nums.length;i ++) {
                //判断是否还需要继续
                if (nums[i] > 0) break;
                //首先去重
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int left = i + 1;
                int right = nums.length - 1;
                //循环找规律
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] > 0) {
                        //左移right 记得去重
                        right --;
                    }else if (nums[i] + nums[left] + nums[right] < 0) {
                        left ++;
                    }else {
                        //增加到结果中
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[left]); temp.add(nums[right]);
                        res.add(temp);
                        //去重
                        right --;
                        left ++;
                        while (right >left && nums[right] == nums[right + 1]) right --;
                        while (right >left && nums[left] == nums[left - 1]) left ++;
                    }
                }

            }
            return res;
        }
    }
}
