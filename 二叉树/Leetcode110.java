package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode110 {
    //解法1：8：47
    //遞歸的方法，思路很簡單，"從下向上" 判斷是否為平衡樹
    class Solution {
        public boolean isBalanced(TreeNode root) {
            int height = getHeight(root);
            if (height != -1) return true;
            else return false;
        }
        public int getHeight(TreeNode treeNode) {
            if (treeNode == null) return 0;
            int leftHeight = getHeight(treeNode.left);
            int rightHeight = getHeight(treeNode.right);
            if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) return -1;
            else return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //解法2：迭代的方法，後序遍歷
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root!= null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode inNode = stack.peek();
                // 右结点为null或已经遍历过
                if (inNode.right == null || inNode.right == pre) {
                    // 比较左右子树的高度差，输出
                    if (Math.abs(getHeight(inNode.left) - getHeight(inNode.right)) > 1) {
                        return false;
                    }
                    stack.pop();
                    pre = inNode;
                    root = null;// 当前结点下，没有要遍历的结点了
                } else {
                    root = inNode.right;// 右结点还没遍历，遍历右结点
                }
            }
            return true;
        }
        //層序遍歷來檢測深度其實有點耗費資源了、
        public int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            int depth = 0;
            while (!deque.isEmpty()) {
                int size = deque.size();
                depth++;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = deque.poll();
                    if (poll.left != null) {
                        deque.offer(poll.left);
                    }
                    if (poll.right != null) {
                        deque.offer(poll.right);
                    }
                }
            }
            return depth;
        }
    }
}
