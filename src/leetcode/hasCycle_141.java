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
public class hasCycle_141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head, fast = head;
            while(fast!=null){
                if(fast.next==null || fast.next.next==null) return false;
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast)    return true;
            }
            return false;
        }
    }
}
