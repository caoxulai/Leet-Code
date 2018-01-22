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
public class isPalindrome_234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null)    return true;
            ListNode slow = head, fast = head;
            ListNode pre = null, post = head;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                
                post = slow.next;
                slow.next = pre;
                pre = slow;
                slow = post;
            }
            if(fast!=null){
                post = post.next;
            }
            while(pre!=null && post!=null){
                if(post.val != pre.val) return false;
                post = post.next;
                pre = pre.next;
            }
            return true;
        }
    }
}
