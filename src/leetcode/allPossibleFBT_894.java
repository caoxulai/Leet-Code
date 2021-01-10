package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class allPossibleFBT_894 {
    // Use memo to store calculated results.
    private Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if(memo.get(N) != null)
            return memo.get(N);

        List<TreeNode> ans = new ArrayList<>();
        if(N == 1)
            ans.add(new TreeNode(0));
        else if(N % 2 == 0)
            return ans;

        for(int i=1; i<= N-2; i += 2) {
            for(TreeNode left : allPossibleFBT(i)) {
                for(TreeNode right : allPossibleFBT(N-1-i)) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        memo.put(N, ans);
        return ans;
    }
}
