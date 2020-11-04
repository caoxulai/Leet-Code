package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class flipEquiv_951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)  return true;
        if(root1 == null || root2 == null)  return false;
        if(root1.val != root2.val)  return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root1);
        queue2.offer(root2);
        while(!queue1.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(equals(node1.left, node2.left) && equals(node1.right, node2.right)) {
                if(node1.left != null) {
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                }
                if(node1.right != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                }
            }
            else if(equals(node1.left, node2.right) && equals(node1.right, node2.left)) {
                if(node1.left != null) {
                    queue1.offer(node1.left);
                    queue2.offer(node2.right);
                }
                if(node1.right != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.left);
                }
            }
            else
                return false;
        }
        return true;
    }

    private boolean equals(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null)  return true;
        if(node1 == null || node2 == null)  return false;
        return node1.val == node2.val;
    }
}
