/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */

import javax.swing.*;

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
public class Leetcode203 {
    /**
     * 题解1 18分钟ac
     * 思路：
     * 一个个查找查到后删除
     * 循环条件：temp.next != null
     * temp.val == val 那么删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {

        if (head == null) return head;
        // 先确定头结点
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) return head;
        //已确定头结点，现在从前向后找
        ListNode temp1 = head;
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == val) {
                temp1.next = temp.next;
                temp = temp.next;
                continue;
            }
            //注意，删完之后的操作是temp1不变，temp向后移
            temp1= temp;
            temp = temp.next;
        }
        return head;
    }

    /**
     * 题解2 (虚拟头结点)
     * 思路:
     * 删除可能涉及到头节点，所以设置dummy节点，统一操作
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;//虚拟头结点
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}
