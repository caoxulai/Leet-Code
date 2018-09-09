package leetcode;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses_093 {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(restoreIpAddresses("010010"));
    }

    public static List<String> restoreIpAddresses(String s) {
        return possibleCombinations(s, 4);
    }

    private static List<String> possibleCombinations(String s, int n) {
        int len = s.length();

        ArrayList<String> res = new ArrayList<>();
        if (len < n || len > 3 * n) return res;
        for (int i = 1; i <= 3 && i <= len; i++) {
            if(i > 1 && s.charAt(0) == '0')
                break;
            StringBuilder sb = new StringBuilder();
            int A = Integer.parseInt(s.substring(0, i));
            if (A >= 0 && A <= 255) {
                if (n == 1) {
                    if (i == len) {
                        res.add(sb.append(A).toString());
                        return res;
                    }
                } else {
                    sb.append(A).append('.');
                    List<String> suffixes = possibleCombinations(s.substring(i), n - 1);
                    if (suffixes.size() != 0) {
                        int lenA = sb.length();
                        for (String suffix : suffixes) {
                            sb.append(suffix);
                            res.add(sb.toString());
                            sb.setLength(lenA);
                        }
                    }
                }
            }
        }
        return res;
    }

}
