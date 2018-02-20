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
public class numDecodings_092 {
    class Solution {
        public int numDecodings(String s) {
            if(s == null || s.length() == 0)    return 0;
            
            int[] dp = new int[s.length()+1];
            
            dp[s.length()] = 1;
            dp[s.length()-1] = s.charAt(s.length()-1) == '0'? 0 : 1;
            
            for(int i=s.length()-2; i>=0; i--){
                if(s.charAt(i) == '0')  continue;
                dp[i] += dp[i+1];
                if(Integer.valueOf(s.substring(i, i+2)) <= 26)
                    dp[i] += dp[i+2];
            }
            return dp[0];
        }
    }
}
