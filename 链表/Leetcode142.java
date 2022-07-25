import java.util.Set;

public class Leetcode142 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        /**
         * 10分钟ac
         * 解法1：哈希解法
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> detected = new HashSet<>();
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode cur;
            cur = dummy.next;
            while (cur != null && !detected.contains(cur)) {
                detected.add(cur);
                cur = cur.next;
            }
            if (cur == null) {
                return null;
            } else {
                return cur;
            }


        }
    }
    public class Solution2 {
        /**
         *
         * 解法2：快慢指针法
         * 可能有点难想
         * 一个快指针走两步，一个慢指针走一步，相遇则有环
         * 找入口的时候还是双指针法，一个从头结点开始，一个从相遇节点开始
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode fast;
            ListNode slow;
            fast = dummy;
            slow = dummy;
            if(head == null) return null;
            do {
                fast = fast.next.next;
                slow = slow.next;
            }while((fast != null && fast.next != null) && fast != slow);
            if (fast != slow) return null;
            ListNode a = dummy; //从头结点开始
            ListNode b = fast; //从相遇节点开始
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;
        }
    }
}
