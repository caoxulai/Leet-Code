package leetcode;

public class sortString_1370 {
    public String sortString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
            for(int i=0; i<26; i++) {
                if(count[i]-- > 0){
                    sb.append('a' + i);
                }
            }
            for(int i=25; i>=0; i--) {
                if(count[i]-- > 0){
                    sb.append('a' + i);
                }
            }
        }
        return sb.toString();
    }
}
