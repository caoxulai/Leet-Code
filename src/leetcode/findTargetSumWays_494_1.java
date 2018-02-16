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
public class findTargetSumWays_494_1 {
    // 78.81%
    // dp, O(ln) time, O(l) space
    // build the sumWays by addint elements one at a time.
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for(int num: nums)  sum += num;
            if(S > sum || S<-sum)   return 0;
            int[] dp = new int[2*sum +1];
            dp[sum] = 1;
            for(int num: nums){
                int[] next = new int[2*sum +1];
                for(int i=0; i<2*sum+1; i++){
                    if(dp[i] != 0){
                        next[i+num] += dp[i];
                        next[i-num] += dp[i];
                    }
                }
                dp = next;
            }
            return dp[sum+S];
        }
    }
}
