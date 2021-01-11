package leetcode;

import leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class pruneTree_814 {


    private Map<TreeNode, Boolean> toRemove = new HashMap<>();

    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;

        // calculate if the node needs to be removed
        // O(n) time
        pruneNode(root);

        if(toRemove.get(root) == true)
            return null;

        // based on the result, remove the zero node
        // O(n) time
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left != null && toRemove.get(node.left) == false)
                queue.offer(node.left);
            else
                node.left = null;

            if(node.right != null && toRemove.get(node.right) == false)
                queue.offer(node.right);
            else
                node.right = null;
        }
        return root;
    }

    private boolean pruneNode(TreeNode node) {
        if(node == null)
            return false;
        boolean leftChildPersist = pruneNode(node.left);
        boolean rightChildPersist = pruneNode(node.right);
        boolean persist = node.val == 1 || leftChildPersist || rightChildPersist;

        toRemove.put(node, !persist);
        return persist;
    }
}
