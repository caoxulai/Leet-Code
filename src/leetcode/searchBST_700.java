package leetcode;

import leetcode.util.TreeNode;

public class searchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        else if(root.val > val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }
}
