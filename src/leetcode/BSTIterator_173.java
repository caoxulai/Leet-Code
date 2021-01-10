package leetcode;

import leetcode.util.TreeNode;

import java.util.Stack;

public class BSTIterator_173 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    
    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            // O(logn)
            stack = new Stack<>();
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            // O(logn)
            TreeNode node = stack.pop();
            TreeNode right = node.right;
            while(right != null){
                stack.push(right);
                right = right.left;
            }
            return node.val;
        }

        public boolean hasNext() {
            // O(1)
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
