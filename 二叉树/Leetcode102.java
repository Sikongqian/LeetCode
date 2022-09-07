package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode102 {
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
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> res = new LinkedList<>();
            if (root != null) queue.offer(root);
            else return res;
            TreeNode tempNode = null;
            while (!queue.isEmpty()) {
                queue.offer(null);
                List<Integer> temp = new LinkedList<>();
                while (queue.peekFirst() != null) {
                    tempNode = queue.poll();
                    temp.add(tempNode.val);
                    if (tempNode.left != null) queue.offer(tempNode.left);
                    if (tempNode.right != null) queue.offer(tempNode.right);
                }
                res.add(temp);
                queue.poll();
            }
            return res;
        }
    }
}
