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
public class longestPalindromeSubseq_516 {
    
    public static void main(String [] args)
    {
        System.out.println(longestPalindromeSubseq("cbbd"));
    }    
    
    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int j=0; j<s.length(); j++){
            dp[j][j] = 1;
            for(int i=j-1; i>=0; i--){
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }
}
