package tree;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode101 {
    // 20分钟ac
    //方法1：递归方法，因为对称其实实质是相等
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left, root.right);
    }
    public boolean isSym(TreeNode a, TreeNode b) {
        if (!isEqual(a, b)) return false;
        if (a == null && b == null) return true;
        if (!isSym(a.left, b.right)) return false;
        if (!isSym(a.right, b.left)) return false;
        return true;
    }

    private boolean isEqual(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null && b != null) return false;
        if (a != null && b == null) return false;
        if (a.val != b.val) return false;
        return true;
    }
    //方法2：迭代的方法也是两个一组的拿出来,用层序遍历的方法更清晰些
    public boolean isSymmetric1(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode tempA = null;
        TreeNode tempB = null;
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            tempA = queue.poll();
            tempB = queue.poll();
            if (!isEqual(tempA, tempB)) return false;
            if (tempA == null && tempB == null) continue;
            queue.offer(tempA.left);queue.offer(tempB.right);
            queue.offer(tempB.left);queue.offer(tempA.right);
        }
        return true;
    }
}
