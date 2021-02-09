package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

public class addTwoNumbers_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1r = reverse(l1);
        ListNode l2r = reverse(l2);
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        int carry = 0;
        while(l1r != null || l2r != null || carry != 0) {
            int v1 = 0, v2 = 0;
            if(l1r != null) {
                v1 = l1r.val;
                l1r = l1r.next;
            }
            if(l2r != null) {
                v2 = l2r.val;
                l2r = l2r.next;
            }
            int sum = v1 + v2 + carry;
            tmp.next = new ListNode(sum % 10);
            tmp = tmp.next;
            carry = sum / 10;
        }

        return reverse(ans.next);
    }

    private ListNode reverse(ListNode node) {
        Stack<Integer> stack = new Stack();
        while(node != null) {
            stack.push(node.val);
            node = node.next;
        }

        ListNode ans = new ListNode();
        ListNode tmp = ans;
        while(!stack.isEmpty()) {
            tmp.next = new ListNode(stack.pop());
            tmp = tmp.next;
        }
        return ans.next;
    }
}
