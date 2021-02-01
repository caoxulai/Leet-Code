package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

public class reverseBetween_092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode ans = new ListNode();
        ans.next = head;
        ListNode tmp = ans;
        while(count < m) {
            tmp = tmp.next;
            count++;
        }

        ListNode reverseHead = tmp;
        Stack<Integer> stack = new Stack<>();
        while(count <= n) {
            stack.push(tmp.next.val);
            tmp = tmp.next;
            count++;
        }

        while(!stack.isEmpty()) {
            reverseHead.next = new ListNode(stack.pop());
            reverseHead = reverseHead.next;
        }
        reverseHead.next = tmp.next;
        return ans.next;
    }
}
