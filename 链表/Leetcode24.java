public class Leetcode24 {
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
    class Solution {

        /**
         * 解法1：14分钟ac
         * 设置伪头，循环条件为当前节点不为空且接下来的节点不为空
         * @param head
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            //设置伪头
            listNode dummy = new ListNode();
            dummy.next = head;
            //循环，终止条件为前一个节点为null，或当前节点为null
            ListNode cur = dummy.next;
            ListNode pre = dummy;
            ListNode curNext = cur;
            while (cur != null && cur.next != null) {
                curNext = cur.next;
                pre.next = curNext;
                cur.next = curNext.next;
                curNext.next = cur;
                pre = cur;
                cur = pre.next;
            }
            return dummy.next;
        }
    }
}
