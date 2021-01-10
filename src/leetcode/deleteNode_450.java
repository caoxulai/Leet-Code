package leetcode;

import leetcode.util.TreeNode;

public class deleteNode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)    return null;
        else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else {
            if(root.left == null)   return root.right;
            else if(root.right == null) return root.left;

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
