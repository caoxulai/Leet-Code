package leetcode;

public class scoreOfParentheses_856 {
    public int scoreOfParentheses(String S) {
        int ans = 0, depth = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (S.charAt(i-1) == '(')
                    ans += 1 << depth;
            }
        }
        return ans;
    }
}
