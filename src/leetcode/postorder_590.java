package leetcode;

import leetcode.util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class postorder_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            for(Node child: node.children) {
                stack.push(child);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
