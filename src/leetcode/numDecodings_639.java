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
public class numDecodings_639 {
    // 93.70%
    // Read, read, read the problem carefully
    // In the problem it asked you to mod 10^9+7
    class Solution {
        public int numDecodings(String s) {
            if(s == null || s.length() == 0)    return 0;
            
            long[] dp = new long[s.length()+1];
            
            dp[s.length()] = 1;
            char first = s.charAt(s.length()-1);
            if(first == '*')        dp[s.length()-1] = 9;
            else if(first == '0')   dp[s.length()-1] = 0;
            else                dp[s.length()-1] = 1;
            
            for(int i=s.length()-2; i>=0; i--){
                first = s.charAt(i);
                char second = s.charAt(i+1);
                if(first == '0')  continue;
                else if(first == '*'){
                    dp[i] += 9 * dp[i+1];
                    if(second == '*')
                        dp[i] += 15 * dp[i+2];
                    else if(second >= '0' && second<= '6' ){
                        dp[i] += 2 * dp[i+2];
                    }else{
                        dp[i] += 1 * dp[i+2];
                    }
                }
                else{
                    dp[i] += dp[i+1];
                    if(first == '1'){
                        if(second == '*')
                            dp[i] += 9 * dp[i+2];
                        else
                            dp[i] += dp[i+2];
                    }else if(first == '2'){
                        if(second == '*')
                            dp[i] += 6 * dp[i+2];
                        else if(second <= '6')
                            dp[i] += dp[i+2];
                    }
                }
                
                dp[i] %= 1000000007;
            }
            return (int) dp[0];
        }
    }
}