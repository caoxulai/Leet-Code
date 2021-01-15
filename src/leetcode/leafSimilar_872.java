package leetcode;

import leetcode.util.TreeNode;

public class leafSimilar_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leafSequence(root1).equals(leafSequence(root2));
    }

    private String leafSequence(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        inorder(node, sb);
        return sb.toString();
    }

    private void inorder(TreeNode node, StringBuilder sb) {
        if(node == null)
            return;

        inorder(node.left, sb);
        if(node.left == null && node.right == null) {
            sb.append(node.val);
            sb.append(',');
        }
        inorder(node.right, sb);
    }
}
