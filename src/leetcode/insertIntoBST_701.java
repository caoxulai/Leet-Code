package leetcode;

public class insertIntoBST_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // need a placeholder ans to handle empty intial tree.
        TreeNode child = root, parent = new TreeNode(Integer.MAX_VALUE), ans = parent;
        parent.left = child;
        while(child != null) {
            parent = child;
            if(val < child.val)
                child = parent.left;
            else
                child = parent.right;
        }
        TreeNode node = new TreeNode(val);
        if(val < parent.val){
            parent.left = node;
            node.left = child;
        }else{
            parent.right = node;
            node.right = child;
        }
        return ans.left;
    }
}
