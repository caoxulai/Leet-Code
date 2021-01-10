/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

/**
 *
 * @author Bryce
 */
public class sortedListToBST_109 {
    class Solution {
        ListNode cur;
        public TreeNode sortedListToBST(ListNode head) {
            int lo=1, hi=length(head);
            cur = head;
            return buildTree(lo, hi);
        }
        
        private TreeNode buildTree(int lo, int hi){
            if(lo > hi)    return null;
            int mid = lo + (hi-lo)/2;
            TreeNode left = buildTree(lo, mid-1);
            
            TreeNode node = new TreeNode(cur.val);
            cur = cur.next;
            
            TreeNode right = buildTree(mid+1, hi);
            node.left = left;
            node.right = right;
            
            return node;
        }
        
        private int length(ListNode head){
            int len = 0;
            ListNode node = head;
            while(node != null){
                node = node.next;
                len++;
            }
            return len;
        }
    }
}
