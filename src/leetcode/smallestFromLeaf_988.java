package leetcode;

import leetcode.util.TreeNode;

public class smallestFromLeaf_988 {
    private String smallest = null;
    private String tmp = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return smallest;
    }

    private void dfs(TreeNode node) {
        tmp = (char)(node.val + 'a') + tmp;
        if(node.left == null && node.right == null) {
            if(smallest == null)
                smallest = tmp;
            else
                smallest = smallest.compareTo(tmp) < 0 ? smallest: tmp;
        }else {
            if(node.left != null)
                dfs(node.left);
            if(node.right != null)
                dfs(node.right);
        }
        tmp = tmp.substring(1);
    }
}
