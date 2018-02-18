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
public class diameterOfBinaryTree_543 {
    // Similar to Problem 124
    class Solution {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            height(root);
            return max;
        }
        
        private int height(TreeNode node){
            if(node == null)    return 0;
            int left = height(node.left);
            int right = height(node.right);
            max = Math.max(max, left + right);
            return 1 + Math.max(left, right);
        }
    }
}
