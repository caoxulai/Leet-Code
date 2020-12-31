package leetcode;

public class decodeAtIndex_880_1 {
    public String decodeAtIndex(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            if(Character.isDigit(c)) {
                StringBuilder temp = new StringBuilder(sb.toString());
                for(int i=1; i<c-'0'; i++) {
                    sb.append(temp.toString());
                }
            }else
                sb.append(c);

            if(sb.length() >= K)
                return String.valueOf(sb.charAt(K-1));
        }
        return "";
    }
}
