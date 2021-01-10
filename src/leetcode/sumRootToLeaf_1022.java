package leetcode;

import leetcode.util.TreeNode;

public class sumRootToLeaf_1022 {
    private int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        if(root == null)    return 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int val){
        val = (val << 1) + node.val;
        if(node.left == null && node.right == null)
            ans += val;
        else{
            if(node.left != null)   dfs(node.left, val);
            if(node.right != null)   dfs(node.right, val);
        }
    }
}
