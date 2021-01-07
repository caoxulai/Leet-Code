package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
};

public class preorder_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)    return ans;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            ans.add(node.val);
            List<Node> children = node.children;
            for(int i=children.size()-1; i>=0; i--){
                stack.push(children.get(i));
            }
        }
        return ans;
    }
}
