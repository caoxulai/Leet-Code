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
public class connectTreeLinkNode_116_1 {
    // O(1) space
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }
    
    public class Solution {
        public void connect(TreeLinkNode root) {
            if(root == null) return;
            while(root.left != null){
                TreeLinkNode cur = root;
                while(cur != null){
                    cur.left.next = cur.right;
                    if(cur.next != null)    cur.right.next = cur.next.left;
                    cur = cur.next;
                }
                root = root.left;
            }
        }
    }
}
