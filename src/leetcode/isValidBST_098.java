/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author Bryce
 */
public class isValidBST_098 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        
        private boolean validateBST(TreeNode root, long lo, long hi) {
            if(root==null)  return true;
            if(root.val<=lo || root.val>=hi)  return false;
            return validateBST(root.left, lo, root.val) && validateBST(root.right, root.val, hi);
        }
    }
}
