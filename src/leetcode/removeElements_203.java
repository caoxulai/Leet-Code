package leetcode;

import leetcode.util.ListNode;

public class removeElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode();
        ans.next = head;

        ListNode tmp = ans;
        while(tmp.next != null) {
            if(tmp.next.val == val)
                tmp.next = tmp.next.next;
            else
                tmp = tmp.next;
        }
        return ans.next;
    }
}
