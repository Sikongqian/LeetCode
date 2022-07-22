public class Leetcode206 {
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
         * 解法1：9分钟ac
         * 1指向null，2指向1，3指向2
         * 需要三个指针，pre，cur，las
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head == null) return head;//0个节点
            ListNode pre;
            pre = head.next;
            ListNode cur;
            ListNode las;
            cur = head;
            las = null;
            while (pre != null) {
                cur.next = las;
                las = cur;
                cur = pre;
                pre = pre.next;
            }
            cur.next = las;
            return cur;
        }


        /**
         *解法2：本质相同，不过利用temp存储下一个节点的指针，精简了代码
         */
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode temp = head;
            ListNode cur = head;
            while (cur != null) {
                temp = cur.next;
                cur.next = pre;
                pre =cur;
                cur = temp;
            }
            return pre;
        }

        /**
         * 解法三：递归
         * 终止条件为 传入参数为null
         * 思想：翻转一个链表，等价于先翻转后边的链表，在把当前节点加到连表上
         */
        public ListNode reverse(ListNode cur) {
            if (cur == null || cur.next == null) {
                return cur;
            }
            ListNode tem = reverse(cur.next);
            cur.next.next = cur;
            cur.next = null;
            return tem;
        }
        public ListNode reverseList(ListNode head) {
            return reverse(head);
        }
    }
}
