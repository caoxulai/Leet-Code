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
public class buildTreePreorderAndInorder_105 {
    // Recursion
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(0, 0, inorder.length-1, preorder, inorder);
        }
        
        private TreeNode buildTree(int preS, int inS, int inE, int[] preorder, int[] inorder){
            if(inS == inE)  return new TreeNode(inorder[inS]);
            if(inS > inE)   return null;
            int root = inS;
            while(root <= inE){
                if(preorder[preS] == inorder[root])
                    break;
                root++;
            }
            TreeNode r = new TreeNode(inorder[root]);
            r.left = buildTree(preS+1, inS, root-1, preorder, inorder);
            r.right = buildTree(preS+1+root-inS, root+1, inE, preorder, inorder);
            
            return r;
        }
    }
}
