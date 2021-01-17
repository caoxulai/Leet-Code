package leetcode;

import leetcode.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree_958_1 {
    public boolean isCompleteTree(TreeNode root) {
        boolean firstNull = false;
        Queue<TreeNode> allNodes = new LinkedList<>();
        allNodes.offer(root);
        while(!allNodes.isEmpty()) {
            TreeNode node = allNodes.poll();
            if(node == null)
                firstNull = true;
            else{
                if(firstNull)   return false;
                allNodes.offer(node.left);
                allNodes.offer(node.right);
            }
        }
        return true;
    }
}
ne