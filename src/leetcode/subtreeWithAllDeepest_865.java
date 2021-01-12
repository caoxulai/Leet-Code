package leetcode;

import leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class subtreeWithAllDeepest_865 {
    // O(n) space
    private Map<TreeNode, Integer> depth = new HashMap<>();;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth.put(null, 0);
        if(root == null)    return root;
        // O(n) time
        height(root);
        // O(H) time
        return subtree(root);
    }

    private TreeNode subtree(TreeNode node) {
        if(depth.get(node) == 1)
            return node;
        if(depth.get(node.left) < depth.get(node.right))
            return subtree(node.right);
        else if(depth.get(node.left) > depth.get(node.right))
            return subtree(node.left);
        // this means left and right child have the same height, the tree cannot be trimmed any more
        return node;
    }

    private int height(TreeNode node){
        if(node == null)    return 0;

        int left = height(node.left);
        int right = height(node.right);
        int height = 1 + Math.max(left, right);
        depth.put(node, height);
        return height;
    }
}
