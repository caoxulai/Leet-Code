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
public class buildTreeInorderAndPostorder_106_1 {
    // 93.24%
    // Iterative 
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder.length == 0) return null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode root = new TreeNode(postorder[postorder.length-1]), cur = root;
            for(int i=postorder.length-2, j=inorder.length-1; i>=0; i--){
                if(inorder[j] != cur.val){
                    stack.push(cur);
                    cur.right = new TreeNode(postorder[i]);
                    cur = cur.right;
                }else{
                    j--;
                    while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                        cur = stack.pop();
                        j--;
                    }
                    cur.left = new TreeNode(postorder[i]);
                    cur = cur.left;
                }
            }
            return root;
        }
    }
}
