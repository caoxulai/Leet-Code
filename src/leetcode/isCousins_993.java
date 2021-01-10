package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class isCousins_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y)
            return false;
        Queue<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.offer(root);
        int xParent = -1, yParent = -1;
        while(!currentLevel.isEmpty()) {
            int currentSize = currentLevel.size();
            for(int i=0; i<currentSize; i++) {
                TreeNode node = currentLevel.poll();
                if(node.left != null) {
                    currentLevel.offer(node.left);
                    if(node.left.val == x)
                        xParent = i;
                    else if(node.left.val == y)
                        yParent = i;
                }
                if(node.right != null) {
                    currentLevel.offer(node.right);
                    if(node.right.val == x)
                        xParent = i;
                    else if(node.right.val == y)
                        yParent = i;
                }
            }
            if(xParent != -1 && yParent != -1) {
                if(xParent != yParent)
                    return true;
                else return false;
            }
            else if(xParent != -1 || yParent != -1)
                return false;
            xParent = -1;
            yParent = -1;
        }
        return false;
    }
}
