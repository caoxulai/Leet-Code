package leetcode;

public class restoreString_1258 {
    public String restoreString(String s, int[] indices) {
        char[] charArray = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            charArray[indices[i]] = s.charAt(i);
        }
        return String.valueOf(charArray);
    }
}