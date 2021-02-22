package leetcode;

import leetcode.util.ListNode;
import leetcode.util.TreeNode;

public class isSubPath_1367 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null)
            return true;
        else if(root == null)
            return false;
        return dfs(head, root)
                || isSubPath(head, root.left) || isSubPath(head, root.right);
    }


    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }

}
