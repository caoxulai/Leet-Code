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
public class numSquares_279 {
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            for(int i=1; i<=n; i++){
                int min = Integer.MAX_VALUE;
                for(int j=1; j*j<=i; j++){
                    min = Math.min(min, dp[i-j*j]+1);
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }
}
