package leetcode;

import leetcode.util.ListNode;

public class oddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode ans = new ListNode();
        ans.next = head;
        ListNode slow = ans;
        ListNode fast = head;
        while(fast.next!= null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next;

            ListNode tmp = fast.next;
            fast.next = fast.next.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        return ans.next;
    }
}
