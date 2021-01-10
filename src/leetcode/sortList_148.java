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
public class sortList_148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null)   return head;
            
            ListNode slow = new ListNode(0), fast=slow;
            slow.next = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode secondHead = slow.next;
            slow.next = null;
            
            head = sortList(head);
            secondHead = sortList(secondHead);
            
            return mergeList(head, secondHead);
            
        }
        
        private ListNode mergeList(ListNode l1, ListNode l2){
            ListNode res = new ListNode(0);
            ListNode head = res;
            
            while(l1 != null && l2 != null){
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
