/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Stack;

/**
 *
 * @author I852047
 */
public class buildTreePreorderAndInorder_105_1 {
    // Iterative
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(preorder[0]), cur = root;
            for(int i=1, j=0; i<preorder.length; i++){
                if(inorder[j] != cur.val){
                    stack.push(cur);                    
                    cur.left = new TreeNode(preorder[i]);
                    cur = cur.left;
                }else{
                    j++;
                    while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                        cur = stack.pop();
                        j++;
                    }
                    cur.right = new TreeNode(preorder[i]);
                    cur = cur.right;
                }
            }
            return root;
        }
    }
    
}
