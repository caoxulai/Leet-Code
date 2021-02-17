package leetcode;

import leetcode.util.ListNode;

public class mergeInBetween_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode();
        head.next = list1;
        ListNode ans = head;

        for(int i=0; i<a; i++) {
            head = head.next;
        }

        ListNode toRemove = head.next;
        head.next = list2;

        for(int i=0; i<b-a; i++) {
            toRemove = toRemove.next;
        }
        while(head.next != null) {
            head = head.next;
        }

        head.next = toRemove.next;
        return ans.next;
    }
}
