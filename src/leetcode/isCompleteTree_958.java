package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree_958 {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)    return true;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);
        boolean lastLevelIncomplete = false;
        while(!currentLevel.isEmpty()) {
            int nulls = 0;
            int size = currentLevel.size();
            for(int i=0; i<size; i++) {
                TreeNode node = currentLevel.poll();
                if(node.left == null){
                    nulls++;
                }else {
                    if(nulls > 0)
                        return false;
                    currentLevel.offer(node.left);
                }
                if(node.right == null){
                    nulls++;
                }else {
                    if(nulls > 0)
                        return false;
                    currentLevel.offer(node.right);
                }
            }
            if(lastLevelIncomplete && !currentLevel.isEmpty())
                return false;
            lastLevelIncomplete = nulls > 0;
        }
        return true;
    }
}
