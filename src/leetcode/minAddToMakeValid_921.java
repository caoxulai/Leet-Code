package leetcode;

public class minAddToMakeValid_921 {
    public int minAddToMakeValid(String S) {
        int left = 0, pair = 0;
        for(char c : S.toCharArray()) {
            if(c == '(')
                left++;
            else if(c == ')' && left > 0){
                left--;
                pair++;
            }
        }
        return S.length() - 2 * pair;
    }
}
