package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue_513 {
    public int findBottomLeftValue(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);
        while(!currentLevel.isEmpty()) {
            ans = currentLevel.peek().val;
            int currentSize = currentLevel.size();
            for(int i=0; i<currentSize; i++) {
                TreeNode node = currentLevel.poll();
                if(node.left != null)   currentLevel.offer(node.left);
                if(node.right != null)   currentLevel.offer(node.right);
            }
        }
        return ans;
    }
}
