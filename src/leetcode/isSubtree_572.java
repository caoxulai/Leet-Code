/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

/**
 *
 * @author Bryce
 */
public class isSubtree_572 {
    // 80.04%
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s == null && t == null)  return true;
            if(s == null || t == null)  return false;
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        
        private boolean isSameTree(TreeNode a, TreeNode b){
            if(a == null && b == null)  return true;
            if(a == null || b == null || a.val != b.val)  return false;
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }
    }
}
