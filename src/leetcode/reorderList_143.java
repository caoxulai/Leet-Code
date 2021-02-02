package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

public class reorderList_143 {
    public void reorderList(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode tmp = head;
        while(tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        int size = stack.size();
        ListNode tmp2 = new ListNode();
        tmp2.next = head;
        for(int i=0; i<size/2; i++) {
            ListNode node = new ListNode(stack.pop());
            node.next = tmp2.next.next;
            tmp2.next.next = node;
            tmp2 = tmp2.next.next;
        }
        if(size % 2 ==1)
            tmp2.next.next = null;
        else
            tmp2.next = null;

    }
}
