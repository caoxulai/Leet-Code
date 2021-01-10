/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author I852047
 */
public class inorderTraversal_094 {
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            inorder(root);
            return res;
        }
        
        private void inorder(TreeNode node){
            if(node == null)    return;
            inorder(node.left);
            res.add(node.val);
            inorder(node.right);
        }
    }
}
