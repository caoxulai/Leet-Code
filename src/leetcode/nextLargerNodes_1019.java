package leetcode;

import leetcode.util.ListNode;

import java.util.Stack;

public class nextLargerNodes_1019 {
    public int[] nextLargerNodes(ListNode head) {
        // O(n) time, O(n) space
        int len = length(head);
        int[] ans = new int[len];
        Stack<int[]> stack = new Stack();
        for(int i=0; i<len; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < head.val) {
                int[] indexToVal = stack.pop();
                ans[indexToVal[0]] = head.val;
            }
            stack.push(new int[]{i, head.val});
            head = head.next;
        }
        return ans;
    }

    private int length(ListNode head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
