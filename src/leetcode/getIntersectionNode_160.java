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
public class getIntersectionNode_160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode a = headA;
            ListNode b = headB;
            while(a!=null && b!=null){
                a = a.next;
                b = b.next;
            }
            while(a!=null){
                headA = headA.next;
                a = a.next;
            }
            while(b!=null){
                headB = headB.next;
                b = b.next;
            }
            
            while(headA!=null && headB!=null){
                if(headA==headB)    return headA;
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
    }
}
