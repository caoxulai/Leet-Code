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
public class uniquePaths_062 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i=0; i<m; i++){
                for(int j=1; j<n; j++){
                    if(i==0)    dp[j] = 1;
                    else    dp[j] += dp[j-1];
                }
            }
            return dp[n-1];
        }
    }
}
