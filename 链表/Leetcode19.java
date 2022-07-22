public class Leetcode19 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    //移除倒数第n个元素
    class Solution {
        /**
         * 解法1：快慢双指针法，8分钟ac
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //设置伪头节点
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            //设置快慢双指针
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 1;i < n;i ++) {
                fast = fast.next;
            }
            //两个指针一起向后走
            while (fast.next != null) {
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }
            pre.next = slow.next;
            return dummy.next;
        }
    }
}
