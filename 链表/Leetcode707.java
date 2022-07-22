import java.util.LinkedList;
import java.util.List;

public class Leetcode707 {
    /**
     * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。
     * 如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
     *
     * 在链表类中实现这些功能.
     * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
     * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
     * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，
     * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
     */

    /**
     * MyLinkedList linkedList = new MyLinkedList();
     * linkedList.addAtHead(1);
     * linkedList.addAtTail(3);
     * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
     * linkedList.get(1);            //返回2
     * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
     * linkedList.get(1);            //返回3
     */

    /**
     * 解法1 没有将listnode与Mylikedlist 分开 耗时1小时12分钟
     */
    class MyLinkedList {
        int val;
        MyLinkedList next;

        /**
         * 注意此时 val为0 next为null为默认链表为空
         * val的值为 1-1000
         */
        public MyLinkedList() {
            //初始化
            val = 0;
            next = null;
        }

        /**
         * 一个一个找
         * 要找的是index处元素
         * @param index
         * @return
         */
        public int get(int index) {
            MyLinkedList cur = this;
            //链表中没有元素or给定下标小于0
            if(index < 0 || cur.val == 0) return -1;
            for (int i = 0;i < index;i ++) {
                //链表长度没有到index
                if(cur == null) return -1;
                cur = cur.next;
            }
            //链表长度为index
            if (cur == null) return -1;
            return cur.val;
        }

        /**
         * 链表为空，直接将值替换就好。
         * 否则新建一个节点，将头结点值放入该节点，并插入链表第二节点
         * 最后将头结点值替换
         * @param val
         */
        public void addAtHead(int val) {
            if (this.val == 0) {
                this.val = val;
            }else {
                MyLinkedList head = new MyLinkedList();
                head.val = this.val;
                this.val = val;
                head.next = this.next;
                this.next = head;
            }
        }

        /**
         * 如果链表为空，那么直接将值替换即可
         * 不为空，遍历找到最后节点
         * @param val
         */
        public void addAtTail(int val) {
            if (this.val == 0) {
                this.val = val;
            }else {
                MyLinkedList cur = this;
                while (cur.next != null) {
                    cur = cur.next;
                }
                MyLinkedList tail = new MyLinkedList();
                tail.val = val;
                cur.next = tail;
            }
        }

        /**
         * addAtIndex(index,val)：在链表中的第index个节点之前添加值为val 的节点。如果index等于链表的长度，
         * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         * @param index
         * @param val
         */
        public void addAtIndex(int index, int val) {
            if(index <= 0) {
                this.addAtHead(val);
            }else {
                //链表为空，return
                if (this.val == 0) return;
                MyLinkedList cur = this;
                MyLinkedList pre = this;
                //此时cur代表index为i的节点
                for (int i = 0;i < index;i ++) {
                    if(cur == null) return;
                    pre = cur;
                    cur = cur.next;
                }
                if (cur == null) {
                    //此时index为链表长度，直接加上就行
                    MyLinkedList temp = new MyLinkedList();
                    temp.val = val;
                    pre.next = temp;
                }else {
                    //此时需要插入
                    MyLinkedList temp = new MyLinkedList();
                    temp.val = val;
                    temp.next = cur;
                    pre.next = temp;
                }

            }
        }

        /**
         * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
         * @param index
         */
        public void deleteAtIndex(int index) {
            //链表为空，返回
            if (this.val == 0) return;
            //链表只有一个元素，并且index为0，置为空返回
            if (this.next == null) {
                if (this.val == 0) {
                    this.val = 0;
                    return;
                }else {
                    return;
                }
            }
            //链表不为空，但index小于0，返回
            if (index < 0) {
                return;
            } else if (index == 0) {
                //删除头结点，将第二个节点复制到第一个，再把第二个节点删除
                this.val = this.next.val;
                this.next = this.next.next;
                return;
            }else {
                MyLinkedList cur = this;
                MyLinkedList pre = this;
                for(int i = 0;i < index;i ++) {
                    if(cur == null) return;
                    pre = cur;
                    cur = cur.next;
                }
                if (cur == null) return;
                pre.next = cur.next;
                return;
            }

        }
    }

    /**
     * 解法2： 不应该被限制思维，可以设置一个伪头结点，这样头节点永不为空
     * 而且，添加伪头可以让全部节点的操作相同
     * 还可以设计一个size
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(){
        }
        ListNode(int val){
            this.val = val;
        }
    }

    class MyLinkedList {
        int size;
        ListNode head;
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        /**
         * 一个一个找
         * 要找的是index处元素
         */
        public int get(int index) {
            if(index < 0 || index >= size) return -1;
            ListNode pre = head;
            for (int i = 0;i < index;i ++) {
                pre = pre.next;
            }
            return pre.next.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            ListNode pre = head;
            for (int i = 0;i < index;i ++) {
                pre = pre.next;
            }
            size++;
            ListNode temp = new ListNode(val);
            temp.next = pre.next;
            pre.next =temp;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            ListNode pre = head;
            for (int i = 0;i < index;i ++) {
                pre = pre.next;
            }
            size--;
            pre.next = pre.next.next;
        }
    }
}
