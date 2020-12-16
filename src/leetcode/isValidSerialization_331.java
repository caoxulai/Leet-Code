package leetcode;

import java.util.Stack;

public class isValidSerialization_331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        if(nodes.length %2 == 0)
            return false;

        Stack<String> stack = new Stack<>();
        for (int pos = 0; pos < nodes.length; pos++) {
            String node = nodes[pos];
            while (node.equals("#") && !stack.isEmpty() && stack.peek().equals(node)) {
                // removing the branches has 2 leaves,
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
