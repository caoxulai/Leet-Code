package leetcode;

import leetcode.util.TreeNode;

public class pruneTree_814_1 {
    // O(n) time, O(n) space
    public TreeNode pruneTree(TreeNode root) {
        return pruneNode(root) ? root : null;
    }

    private boolean pruneNode(TreeNode node) {
        if(node == null)
            return false;

        boolean leftChildPersist = pruneNode(node.left);
        boolean rightChildPersist = pruneNode(node.right);

        if(!leftChildPersist)   node.left = null;
        if(!rightChildPersist)   node.right = null;

        return node.val == 1 || leftChildPersist || rightChildPersist;
    }
}
