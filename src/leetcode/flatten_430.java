package leetcode;


import java.util.Stack;

public class flatten_430 {
    public Node flatten(Node head) {
        if(head == null)
            return head;
        Stack<Node> stack = new Stack<>();
        // node to store
        Node ans = new Node();
        Node tmp = ans;
        stack.push(head);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            while(node != null) {
                node.prev = tmp;
                tmp.next = node;
                tmp = tmp.next;

                if(node.child != null) {
                    if(node.next != null) {
                        stack.push(node.next);
                    }
                    stack.push(node.child);
                    node.child = null;
                    break;
                }
                node = node.next;
            }
        }
        ans.next.prev = null;
        return ans.next;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
