package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class getShortestUniquePath {
    private List<TreeNode> findMatch(TreeNode root, int target) {
        List<TreeNode> matches =  new ArrayList();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            if(target == node.val) {
                matches.add(node);
            }

            for(TreeNode child : node.children) {
                if(child != null)
                    nodes.offer(child);
            }
        }
        return matches;
    }

    private String getShortestUniquePath(List<TreeNode> matches, TreeNode target) {
        String ans = String.valueOf(target.val);
        while(matches.size() > 1) {
            List<TreeNode> matchedParents = new ArrayList<>();
            for(TreeNode match : matches) {
                if(match.parent.val == target.parent.val){
                    matchedParents.add(match.parent);
                }
            }
            target = target.parent;
            matches = matchedParents;
            ans = String.valueOf(target.val) + "/" + ans;
        }
        return ans;
    }

    public class TreeNode {
        int val;
        TreeNode parent;
        List<TreeNode> children;
        TreeNode(int x, TreeNode parent) {
            val = x;
            this.parent = parent;
        }
    }
}
