package leetcode;

public class longestCommonPrefix_014 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(true) {
            if(strs[0].length() < i+1)
                break;
            char c = strs[0].charAt(i);
            boolean flag = false;
            for(String s : strs) {
                if(s.length() < i+1 || s.charAt(i) != c) {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;

            sb.append(c);
            i++;
        }
        return sb.toString();
    }
}
