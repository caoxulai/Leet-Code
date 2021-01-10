package leetcode;

import leetcode.util.TreeNode;

public class longestUnivaluePath_687_1 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        height(root);
        return max;
    }

    // return the height of the node only considering same-value children
    private int height(TreeNode node){
        if(node == null)    return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int pathLeft = 0, pathRight = 0;
        if(node.left != null && node.val == node.left.val)
            pathLeft += leftHeight + 1;
        if(node.right != null && node.val == node.right.val)
            pathRight += rightHeight + 1;
        max = Math.max(max, pathLeft + pathRight);

        return Math.max(pathLeft, pathRight);
    }

}
