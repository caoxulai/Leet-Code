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
public class lowestCommonAncestorBST_235 {
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            while (true) {
                if (root.val > p.val && root.val > q.val)
                    root = root.left;
                else if (root.val < p.val && root.val < q.val)
                    root = root.right;
                else
                    return root;
            }
        }
    }
}
