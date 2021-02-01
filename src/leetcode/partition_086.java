package leetcode;

import leetcode.util.ListNode;

public class partition_086 {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode greater = new ListNode();
        ListNode lessHead = less;
        ListNode greaterHead = greater;

        while(head != null) {
            if(head.val < x) {
                less.next = head;
                less = less.next;
            }else {
                greater.next = head;
                greater = greater.next;

            }
            head = head.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;
    }
}
