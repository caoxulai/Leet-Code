package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class isEvenOddTree_1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);
        int odd = 1;
        while(!currentLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            int sign = odd == 1 ? 1 : -1;
            int previouseVal = odd == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(!currentLevel.isEmpty()) {
                TreeNode node = currentLevel.poll();
                if(node.val % 2 != odd || sign * previouseVal >= sign * node.val) {
                    return false;
                }
                if(node.left != null)   nextLevel.offer(node.left);
                if(node.right != null)   nextLevel.offer(node.right);
                previouseVal = node.val;
            }
            currentLevel = nextLevel;
            odd ^= 1;
        }

        return true;
    }
}
