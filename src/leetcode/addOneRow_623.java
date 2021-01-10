package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class addOneRow_623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)    return root;
        TreeNode ans = new TreeNode(0);
        ans.left = root;
        Queue<TreeNode> currentLevel = new ArrayDeque<>();
        currentLevel.offer(ans);
        for(int level=0; level<d-1 ; level++) {
            int currentSize = currentLevel.size();
            for(int i=0; i<currentSize; i++) {
                TreeNode node = currentLevel.poll();
                if(node.left != null)   currentLevel.offer(node.left);
                if(node.right != null)   currentLevel.offer(node.right);
            }
        }

        for(TreeNode node: currentLevel) {
            TreeNode newLeft = new TreeNode(v);
            newLeft.left = node.left;
            node.left = newLeft;
            TreeNode newRight = new TreeNode(v);
            newRight.right = node.right;
            node.right = newRight;
        }
        return ans.left;
    }
}
