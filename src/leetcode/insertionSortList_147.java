package leetcode;

import leetcode.util.ListNode;

public class insertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode ans = new ListNode();
        ListNode tail = new ListNode();
        tail.next = head;
        while(tail.next != null) {
            ListNode before = ans;
            while(before.next != null && tail.next.val > before.next.val){
                before = before.next;
            }
            ListNode node = tail.next.next;
            tail.next.next = before.next;
            before.next = tail.next;
            tail.next = node;
        }
        return ans.next;
    }
}
