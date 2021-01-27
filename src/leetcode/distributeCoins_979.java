package leetcode;

import leetcode.util.TreeNode;

public class distributeCoins_979 {
    private int steps;
    public int distributeCoins(TreeNode root) {
        steps = 0;
        coinsInOrOut(root);
        return steps;
    }

    private int coinsInOrOut(TreeNode node) {
        if(node == null)    return 0;
        int L = coinsInOrOut(node.left);
        int R = coinsInOrOut(node.right);
        steps += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
