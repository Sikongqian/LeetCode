package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode226 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    //解法1，很容易想到递归解法
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //解法2. 迭代遍历交换左右子节点
    public TreeNode invertTree1(TreeNode root) {
        if(root == null) return root;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode temp = null;
        TreeNode exchangeTemp = null;
        while (!stack.isEmpty()) {
            if (stack.peek() == null) {
                stack.pop();
                temp = stack.pop();
                exchangeTemp = temp.left;
                temp.left = temp.right;
                temp.right = exchangeTemp;
            }else {
                temp = stack.pop();
                if (temp.right != null) stack.push(temp.right);
                stack.push(temp);stack.push(null);
                if (temp.left != null) stack.push(temp.left);
            }
        }
        return root;
    }
}
