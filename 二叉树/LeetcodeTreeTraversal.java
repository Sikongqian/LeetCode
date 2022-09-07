package tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LeetcodeTreeTraversal {
    class Solution {
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
         // 递归遍历
         public void preTra(TreeNode root, List res) {
             if (root == null) return;
             res.add(root.val);
             preTra(root.left, res);
             preTra(root.right, res);
         }
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            preTra(root, res);
            return res;
        }
        public void postTra(TreeNode root, List res) {
            if (root == null) return;
            postTra(root.left, res);
            postTra(root.right, res);
            res.add(root.val);
        }
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            postTra(root, res);
            return res;
        }
        public void inTra(TreeNode root, List res) {
            if (root == null) return;
            inTra(root.left, res);
            res.add(root.val);
            inTra(root.right, res);
        }
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            inTra(root, res);
            return res;
        }

        //迭代遍历
        class Solution1 {
            public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> res = new LinkedList<>();
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                if (temp != null) stack.push(root);
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    res.add(temp.val);
                    if (temp.right != null) stack.push(temp.right);
                    if (temp.left != null) stack.push(temp.left);
                }
                return res;
            }
        }

        // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
        class Solution2 {
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> res = new LinkedList<>();
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                if (temp != null) {
                    stack.add(root);
                }
                while (!stack.isEmpty()) {
                    if(stack.peek().left != null) stack.push(stack.peek().left);
                    else {
                        temp = stack.pop();
                        res.add(temp.val);
                        while(temp.right == null&&!stack.isEmpty()) {
                            temp = stack.pop();
                            res.add(temp.val);
                        }
                        if(temp.right != null) stack.push(temp.right);
                    }
                }
                return res;
            }
        }

        // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左，添加结果时一直向前添加
        class Solution3 {
            public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> res = new LinkedList<>();
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                if (temp != null) stack.push(root);
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    if (temp.left != null) stack.push(temp.left);
                    if (temp.right != null) stack.push(temp.right);
                    res.add(0, temp.val);
                }
                return res;
            }
        }

        //迭代遍历统一形式
        //中序遍历使用栈的话，无法同时解决访问节点（遍历节点）和处理节点（将元素放进结果集）不一致的情况。
        //可以使用空指针做标记
        class Solution4 {
            public List<Integer> postorderTraversal(TreeNode root) {
                List<Integer> res = new LinkedList<>();
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                if (temp != null) stack.push(root);
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    if(temp == null) res.add(stack.pop().val);
                    else{
                        if(temp.right != null) stack.push(temp.right);
                        stack.push(temp);stack.push(null);
                        if(temp.left != null) stack.push(temp.left);
                    }

                }
                return res;
            }
            public List<Integer> preorderTraversal(TreeNode root) {
                List<Integer> res = new LinkedList<>();
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                if (temp != null) stack.push(root);
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    if(temp == null) res.add(stack.pop().val);
                    else{
                        if(temp.right != null) stack.push(temp.right);
                        if(temp.left != null) stack.push(temp.left);
                        stack.push(temp);stack.push(null);
                    }

                }
                return res;
            }
            public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> res = new LinkedList<>();
                Deque<TreeNode> stack = new LinkedList<>();
                TreeNode temp = root;
                if (temp != null) stack.push(root);
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    if(temp == null) res.add(stack.pop().val);
                    else{
                        stack.push(temp);stack.push(null);
                        if(temp.right != null) stack.push(temp.right);
                        if(temp.left != null) stack.push(temp.left);
                    }
                }
                return res;
            }
        }









    }
}
