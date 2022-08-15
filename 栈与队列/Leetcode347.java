package StackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode347 {
    class Solution {
        /**
         * 似乎可以直接哈希 + 快排 emm 但是这是堆栈专题而且快排会超时
         * 解法1:
         * @param nums
         * @param k
         * @return
         */
        public int[] topKFrequent(int[] nums, int k) {
            //首先获取频率
            Map<Integer, Integer> fre = new HashMap<>();
            for (Integer a: nums) {
                if (fre.containsKey(a)) {
                    fre.replace(a, fre.get(a) + 1);
                }else {
                    fre.put(a, 1);
                }
            }
            //对频率进行排序 这里使用小顶堆，此时可以用优先队列
            PriorityQueue<Map.Entry<Integer, Integer>> topK = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
            //有一个难点是优先队列的对比条件, 可以将一个键值对作为一个对象输入,o1 o2 相当于重写了compare函数
            for (Map.Entry<Integer, Integer> a: fre.entrySet()) {
                topK.add(a);
                if (topK.size() > k) {
                    topK.poll();
                }
            }
            //获取topk个元素
            int []result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = topK.poll().getKey();
            }
            return result;
        }
    }
    /**
     优先队列基于堆实现，用Comparator在队列建立时制定优先顺序
     基于顺序的最小值在队列头部
     操作有 poll, remove, peek, element access the element at the head of the queue.
     增长根据自身的实现方式来
     如果想按顺序遍历请 Arrays.sort(pq.toArray()).
     线程不安全 thread-safe PriorityBlockingQueue class.
     O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add);
     linear time for the remove(Object) and contains(Object) methods;
     constant time for the retrieval methods (peek, element, and size).
     since 1.5
     */


}
