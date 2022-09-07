package tree;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode104 {
    //15：24尋找最大深度
    //解法1：層序遍歷加計數 12分鐘ac
    class Solution {
        public int maxDepth(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            TreeNode temp = null;
            if (root == null) return 0;
            queue.offer(root);queue.offer(null);
            while (!queue.isEmpty()) {
                temp = queue.poll();
                if (temp == null) {
                    depth ++;
                    queue.offer(null);
                    if (queue.peekFirst() != null) continue;
                    else break;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            return depth;
        }
    }
    //解法2：遞歸前序or後序
    class Solution1 {
        //前序解法，需要一個全局變量記錄最大值
        public int result = 0;
        public void getResult (TreeNode tree, int depth) {
            if (depth > result) result = depth;
            if (tree.left == null && tree.right == null) return ;
            if (tree.left != null) {
                depth ++;
                getResult(tree.left, depth);
                depth --;
            }
            if (tree.right != null) {
                depth ++;
                getResult(tree.right, depth);
                depth --;
            }
            return;

        }
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            getResult(root, 1);
            return result;
        }
    }
    //後序解法：後序遍歷
    class Solution2 {
        public int getResult (TreeNode tree) {
            int a = 0,b = 0;
            if (tree.left == null && tree.right == null) return 0;
            if (tree.left != null) {
                a = getResult(tree.left);
            }
            if (tree.right != null) {
                b = getResult(tree.right);
            }
            if (a > b) return a + 1;
            else return b + 1;
        }
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = getResult(root);
            return depth;
        }
    }
}
