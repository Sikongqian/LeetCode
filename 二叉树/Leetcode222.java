package tree;

public class Leetcode222 {
    class Solution {
        //沒有自己ac
        //解法1：根據完全二叉樹的特性可以寫出如下代碼
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int rightDepth = 0;
            int leftDepth = 0;
            TreeNode temp = root;
            while (temp.left != null) {
                temp = temp.left;
                leftDepth ++;
            }
            temp = root;
            while (temp.right != null) {
                temp = temp.right;
                rightDepth ++;
            }
            if (leftDepth == rightDepth) return (int) Math.pow(2, leftDepth);
            return countNodes(root.left) + countNodes(root.right);
        }
    }
}
