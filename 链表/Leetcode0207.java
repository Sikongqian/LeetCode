import java.util.HashMap;
import java.util.Set;

public class Leetcode0207 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    //面试题 02.07. 链表相交
    public class Solution {
        //9.19

        /**
         * 解法1：37分钟ac
         * 双指针
         * 先找到尾节点判断是否相交
         * 再根据长度进行偏移
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = 0;
            int lengthB = 0;
            //找出AB链表的尾节点和长度
            ListNode dummyA = new ListNode();
            dummyA.next = headB;
            ListNode tempA = dummyA;
            while (tempA.next != null) {
                tempA = tempA.next;
                lengthA ++;
            }
            ListNode dummyB = new ListNode();
            dummyB.next = headA;
            ListNode tempB = dummyB;
            while (tempB.next != null) {
                tempB = tempB.next;
                lengthB ++;
            }
            //判断是否相交
            if (tempA != tempB) {
                return null;
            }
            //相交则判断哪边长
            tempA = dummyA;
            tempB = dummyB;
            if (lengthA >= lengthB) {
                //A长，A后移
                int offset = lengthA - lengthB;
                for (int i = 0;i < offset;i ++) {
                    tempA = tempA.next;
                }
            }else {
                //B长，B后移
                int offset = lengthB - lengthA;
                for (int i = 0;i < offset;i ++) {
                    tempB = tempB.next;
                }
            }
            while (tempA != tempB) {
                tempA = tempA.next;
                tempB = tempB.next;
            }
            return tempA;
        }

        /**
         * 解法2：哈希集合方法
         * 思路很简单，先把A中节点填入哈希集合，
         * 判断B中节点是否在A中即可
         */
        public class Solution2 {
            public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                Set<ListNode> visited= new HashSet<ListNode>();
                while (headA != null) {
                    visited.add(headA);
                    headA = headA.next;
                }
                while (headB != null) {
                    if (visited.contains(headB)) return headB;
                    headB = headB.next;
                }
                return null;
            }
        }

    }
}
