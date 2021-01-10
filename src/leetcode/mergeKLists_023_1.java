/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.ListNode;

/**
 *
 * @author Bryce
 */
public class mergeKLists_023_1 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        // Merge Sort idea, applying to LinkedList
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null || lists.length==0)  return null;
            for(int step=1; step<lists.length; step *=2){
                for(int i=0; i+step<lists.length; i += 2*step){
                    lists[i] = mergeTwoList(lists[i], lists[i+step]);
                }
            }
            return lists[0];
        }
        
        private ListNode mergeTwoList(ListNode l1, ListNode l2){
            ListNode res = new ListNode(0);
            ListNode head = res;
            while(l1!=null && l2!=null){
                if(l1.val < l2.val){
                    head.next = l1;
                    head = head.next;
                    l1 = l1.next;
                }
                else{
                    head.next = l2;
                    head = head.next;
                    l2 = l2.next;
                }
            }
            if(l1 != null)  head.next = l1;
            if(l2 != null)  head.next = l2;
            
            return res.next;
        }
    }
}
