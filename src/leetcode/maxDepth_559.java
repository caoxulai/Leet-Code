package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class maxDepth_559 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null)    return 0;
        int depth = 0;
        Queue<Node> currentLevel = new LinkedList<>();
        currentLevel.offer(root);
        while(!currentLevel.isEmpty()) {
            depth++;
            Queue<Node> nextLevel = new LinkedList<>();
            while(!currentLevel.isEmpty()) {
                Node parent = currentLevel.poll();
                for(Node child : parent.children) {
                    nextLevel.offer(child);
                }
            }
            currentLevel = nextLevel;
        }
        return depth;
    }
}
