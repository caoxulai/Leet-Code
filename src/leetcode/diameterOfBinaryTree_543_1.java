package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class diameterOfBinaryTree_543_1 {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)    return 0;
        int ans = height(root.left) + height(root.right);
        ans = Math.max(ans, diameterOfBinaryTree(root.left));
        ans = Math.max(ans, diameterOfBinaryTree(root.right));
        return ans;
    }

    private int height(TreeNode node) {
        if(node == null)    return 0;
        int height = 0;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(node);
        while(!currentLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            height ++;
            while(!currentLevel.isEmpty()) {
                TreeNode current = currentLevel.poll();
                if(current.left != null)   nextLevel.offer(current.left);
                if(current.right != null)  nextLevel.offer(current.right);
            }
            currentLevel = nextLevel;
        }
        return height;
    }
}
