package leetcode;

import leetcode.util.TreeNode;

public class getMinimumDifference_530 {

    // O(n) time, O(1) space

    int min = Integer.MAX_VALUE;
    Integer previous = null;

    public int getMinimumDifference(TreeNode root) {
        if(root == null)    return min;

        // In-order traversal
        getMinimumDifference(root.left);

        if(previous != null)
            min = Math.min(min, root.val - previous);
        previous = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}
