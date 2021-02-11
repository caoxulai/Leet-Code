package leetcode;

import leetcode.util.ListNode;

public class swapNodes_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = getNodeAtIndex(head, k);
        ListNode second = getNodeAtIndex(head, length(head)-k+1);
        int t = first.val;
        first.val = second.val;
        second.val = t;
        return head;
    }

    private int length(ListNode head){
        int len = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            len++;
        }
        return len;
    }

    private ListNode getNodeAtIndex(ListNode head, int index) {
        ListNode tmp = head;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}
