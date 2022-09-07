package tree;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode111 {
    class Solution {
        // 13分钟ac
        //解法1：层序遍历，找到第一个叶节点的深度
        public int minDepth(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode temp = root;
            int depth = 0;
            if (root == null) return 0;
            while (true) {
                int flag = 0;
                int length = queue.size();
                depth ++;
                for (int i = 0; i < length; i ++) {
                    temp = queue.poll();
                    if (temp.left == null && temp.right == null) {
                        flag = 1;
                        break;
                    }
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
                if (flag == 1) break;
            }
            return depth;
        }
    }
    class Solution1 {
        // 13分钟ac
        //解法2：前序遍历递归法
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            return getDepth(root);
        }
        public int getDepth(TreeNode root) {
            if (root == null) return 0;
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            if (root.left == null && root.right != null) return right+1;
            if (root.right == null && root.left != null) return left+1;
            return Math.min(right, left)+1;

        }
    }
}
