package leetcode;

import leetcode.util.ListNode;

public class deleteNode_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
