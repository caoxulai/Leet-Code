package leetcode;

import java.util.Stack;

public class backspaceCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        return edit(S).equals(edit(T));
    }

    private String edit(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c != '#')
                stack.push(c);
            else if(!stack.isEmpty())
                stack.pop();
        }
        return String.valueOf(stack);
    }
}
