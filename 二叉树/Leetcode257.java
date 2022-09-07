package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode257 {
    //8：45
    //解法1：前序遍歷
    class Solution {
        Deque<TreeNode> result = new LinkedList<>();
        List<String> res = new LinkedList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            traverse(root);
            return res;
        }
        public void traverse(TreeNode cur) {
            if (cur.left == null && cur.right == null) {
                //返回列表
                record(cur);
                return;
            }
            result.addLast(cur);
            if (cur.left != null) traverse(cur.left);
            if (cur.right != null) traverse(cur.right);
            result.removeLast();
            return;
        }
        //記錄當前result到res裏
        private void record(TreeNode cur) {
            String temp = null;
            for (TreeNode a:result) {
                temp += a.val;
                temp += "->";
            }
            temp += cur.val;
            res.add(temp);
            return;
        }
    }

    //答案中的回溯有一點值得注意，一個遞歸對應一個回溯，不要在最後再回溯。
    //字符串操作還是用stringbuilder or stringbuffer好一些
    class Solution1 {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            List<Integer> paths = new ArrayList<>();
            traversal(root, paths, res);
            return res;
        }

        private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
            paths.add(root.val);
            // 叶子结点
            if (root.left == null && root.right == null) {
                // 输出
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < paths.size() - 1; i++) {
                    sb.append(paths.get(i)).append("->");
                }
                sb.append(paths.get(paths.size() - 1));
                res.add(sb.toString());
                return;
            }
            if (root.left != null) {
                traversal(root.left, paths, res);
                paths.remove(paths.size() - 1);// 回溯
            }
            if (root.right != null) {
                traversal(root.right, paths, res);
                paths.remove(paths.size() - 1);// 回溯
            }
        }
    }
}
