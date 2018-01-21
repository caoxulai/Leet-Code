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
public class addTwoNumbers_002 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(0);
            ListNode head = res;
            int c=0;
            while(c!=0 || l1!=null && l2!=null){
                int v1 = l1==null ? 0: l1.val;
                int v2 = l2==null ? 0: l2.val;
                int sum = v1 + v2 + c;
                c = sum/10;
                sum %= 10;
                head.next = new ListNode(sum);
                head = head.next;
                if(l1!=null)    l1 = l1.next;
                if(l2!=null)    l2 = l2.next;
            }
            
            if(l1!=null)    head.next = l1;
            if(l2!=null)    head.next = l2;
            return res.next;
        }
    }
}
