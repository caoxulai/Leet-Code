package leetcode;

import leetcode.util.TreeNode;

public class sumNumbers_129 {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if(root != null)
            dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int prev){
        prev = prev*10 + node.val;
        if(node.left == null && node.right == null)
            sum += prev;
        if(node.left != null)
            dfs(node.left, prev);
        if(node.right != null)
            dfs(node.right, prev);
    }
}
