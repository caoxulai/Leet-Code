package leetcode;

import leetcode.util.TreeNode;

import java.util.*;

public class distanceK_863 {
    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        recodeParent(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);

        for(int distance=0; distance<K; distance++){
            int size = queue.size();
            for(int j=0; j<size; j++) {
                TreeNode node = queue.poll();
                TreeNode parent = parentMap.get(node);
                processNode(queue, seen, node.left);
                processNode(queue, seen, node.right);
                processNode(queue, seen, parent);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }

        return ans;
    }

    private void processNode(Queue<TreeNode> queue, Set<TreeNode> seen, TreeNode node) {
        if (node != null && !seen.contains(node)) {
            queue.offer(node);
            seen.add(node);
        }
    }

    private void recodeParent(TreeNode node, TreeNode parent) {
        if(node != null) {
            parentMap.put(node, parent);
            recodeParent(node.left, node);
            recodeParent(node.right, node);
        }
    }
}
