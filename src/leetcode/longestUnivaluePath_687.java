package leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class longestUnivaluePath_687 {
    int max = 0;
    Map<Pair<TreeNode, Integer>, Integer> memo = new HashMap<>();

    public int longestUnivaluePath(TreeNode root) {
        if(root != null)
            height(root, root.val);
        return max;
    }

    private int height(TreeNode node, int val){
        if(node == null)    return 0;
        if(memo.get(new Pair<>(node, val)) != null)
            return memo.get(new Pair<>(node, val));

        if(node.left != null)
            height(node.left, node.left.val);
        if(node.right != null)
            height(node.right, node.right.val);

        if(node.val != val) return 0;
        int left = height(node.left, val);
        int right = height(node.right, val);

        max = Math.max(max, left + right);
        int ans = 1 + Math.max(left, right);
        memo.put(new Pair<>(node, val), ans);
        return ans;
    }
}
