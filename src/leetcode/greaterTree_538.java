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
public class greaterTree_538 {
    class Solution {
        int sum = 0;
        
        public TreeNode convertBST(TreeNode root) {
            greaterTree(root);
            return root;
        }
        
        private void greaterTree(TreeNode node){
            if(node == null)    return;
            greaterTree(node.right);
            node.val += sum;
            sum = node.val;
            greaterTree(node.left);
        }
    }
}
