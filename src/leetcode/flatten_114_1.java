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
public class flatten_114_1 {
    // recursion
    class Solution {
        public void flatten(TreeNode root) {
            flatten(root, null);
        }
        
        private TreeNode flatten(TreeNode node, TreeNode next){
            if(node==null)  return next;
            next = flatten(node.right, next);
            next = flatten(node.left, next);
            node.left = null;
            node.right = next;
            return node;
        }
    }
}
