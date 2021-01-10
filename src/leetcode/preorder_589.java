package leetcode;

import leetcode.util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
