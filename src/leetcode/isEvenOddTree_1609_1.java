package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class isEvenOddTree_1609_1 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> remainingNodes = new ArrayDeque<>();
        remainingNodes.offer(root);
        int odd = 1;
        while(!remainingNodes.isEmpty()) {
            int size = remainingNodes.size();
            int sign = odd == 1 ? 1 : -1;
            int previousVal = remainingNodes.peek().val - sign;
            for(int i=0; i<size; i++) {
                TreeNode node = remainingNodes.poll();
                if(node.val % 2 != odd || sign * previousVal >= sign * node.val) {
                    return false;
                }
                if(node.left != null)   remainingNodes.offer(node.left);
                if(node.right != null)   remainingNodes.offer(node.right);
                previousVal = node.val;
            }
            odd ^= 1;
        }

        return true;
    }
}
