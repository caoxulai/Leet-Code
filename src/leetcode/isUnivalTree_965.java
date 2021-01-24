package leetcode;

import leetcode.util.TreeNode;

public class isUnivalTree_965 {
    private int val;

    public boolean isUnivalTree(Tree_889Node root) {
        if(root == null)    return true;
        val = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {
        if(node == null)    return true;
        return node.val == val && dfs(node.left) && dfs(node.right);
    }

}
