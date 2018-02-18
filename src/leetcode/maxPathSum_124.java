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
public class maxPathSum_124 {    
    // Similar to Problem 543
    class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxPathSumDown(root);
            return max;
        }
        
        private int maxPathSumDown(TreeNode node){
            if(node==null)  return 0;
            int left = Math.max(0, maxPathSumDown(node.left));
            int right = Math.max(0, maxPathSumDown(node.right));
            max = Math.max(max, node.val + left + right);
            return node.val + Math.max(left, right);
        }
    }
}
