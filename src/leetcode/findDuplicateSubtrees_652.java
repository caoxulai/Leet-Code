package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findDuplicateSubtrees_652 {
    private Map<String, Integer> count = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }

    private String serialize(TreeNode node) {
        if(node == null)    return "#";
        String key = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        count.put(key, count.getOrDefault(key, 0) + 1);
        if(count.get(key) == 2)
            ans.add(node);
        return key;
    }
}
