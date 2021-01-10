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
public class detectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null){
            if(fast.next==null || fast.next.next==null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)    break;
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
