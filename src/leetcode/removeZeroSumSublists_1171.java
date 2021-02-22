package leetcode;

import leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class removeZeroSumSublists_1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;

        Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();
        ListNode tmp = ans;
        int sum = 0;
        while(tmp != null) {
            sum += tmp.val;
            sumToFarthestNodeMap.put(sum, tmp);
            tmp = tmp.next;
        }

        tmp = ans;
        sum = 0;
        while(tmp != null) {
            sum += tmp.val;
            tmp.next = sumToFarthestNodeMap.get(sum).next;
            tmp = tmp.next;
        }

        return ans.next;
    }
}
