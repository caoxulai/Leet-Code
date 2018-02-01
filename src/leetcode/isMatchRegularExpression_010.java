/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author Bryce
 */
public class isMatchRegularExpression_010 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int len1 = s.length();
            int len2 = p.length();
            boolean[][] isMatch = new boolean[len1 + 1][len2 + 1];
            // isMatch[i][j] indicates whehter the first i char of s matches the first j char of p
            isMatch[0][0] = true;
            for(int j=1; j<=len2; j++){
                if(p.charAt(j-1)=='*')
                    isMatch[0][j] = isMatch[0][j-1] || j>1 && isMatch[0][j-2];
            }
            
            for(int i=1; i<=len1; i++){
                for(int j=1; j<=len2; j++){
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                        isMatch[i][j] = isMatch[i-1][j-1];
                    else if(p.charAt(j-1) == '*'){
                        if(j>1 && p.charAt(j-2)!=s.charAt(i-1) && p.charAt(j-2)!='.')
                            isMatch[i][j] = isMatch[i][j-2];
                        else
                            isMatch[i][j] = isMatch[i-1][j] || isMatch[i][j-1] || j>1 && isMatch[i][j-2];
                    }
                }
            }
            return isMatch[len1][len2];
        }
    }
}
