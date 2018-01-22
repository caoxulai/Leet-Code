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
public class splitListToParts_725 {
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int len = length(root);
            int l = len/k;
            int c = len%k;
            ListNode[] res = new ListNode[k];
            ListNode pre = new ListNode(0);
            pre.next = root;
            res[0] = pre.next;
            for(int i=1; i<k; i++){
                for(int j=0; j<l; j++){
                    pre = pre.next;
                }
                if(c-->0){
                    pre = pre.next;
                }
                res[i] = pre.next;
                pre.next=null;
                pre = new ListNode(0);
                pre.next = res[i];
            }
            return res;
        }
        
        private int length(ListNode root){
            ListNode head = root;
            int len = 0;
            while(head != null){
                head = head.next;
                len++;
            }
            return len;
        }
    }
}
