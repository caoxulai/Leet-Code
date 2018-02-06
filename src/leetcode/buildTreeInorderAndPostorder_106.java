/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author I852047
 */
public class buildTreeInorderAndPostorder_106 {
    // Recursion 
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(postorder.length-1, 0, inorder.length-1, inorder, postorder);
        }
        
        private TreeNode buildTree(int postE, int inS, int inE, int[] inorder, int[] postorder){
            if(inS == inE)  return new TreeNode(inorder[inS]);
            if(inS > inE)   return null;
            int root = inS;
            while(root <= inE){
                if(postorder[postE] == inorder[root])
                    break;
                root++;
            }
            TreeNode r = new TreeNode(inorder[root]);
            r.left = buildTree(postE-1-(inE-root), inS, root-1, inorder, postorder);
            r.right = buildTree(postE-1, root+1, inE, inorder, postorder);
            
            return r;
        }
    }
}
