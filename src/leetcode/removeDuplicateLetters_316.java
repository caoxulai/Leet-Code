package leetcode;

import java.util.Stack;

public class removeDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] existed = new boolean[26];
        for(char c: s.toCharArray()){
            count[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()){
            int index = c-'a';
            count[index]--;
            if(existed[index])
                continue;

            while(!stack.isEmpty() && c<stack.peek() && count[stack.peek()-'a']!=0){
                existed[stack.pop()-'a']=false;
            }
            stack.push(c);

            existed[index]=true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
