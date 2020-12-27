package leetcode;

public class removeOuterParentheses_1021 {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for(char c : S.toCharArray()) {
            if(c == '(' && ++left > 1)          sb.append(c);
            else if(c == ')' && --left > 0)     sb.append(c);
        }
        return sb.toString();
    }
}
