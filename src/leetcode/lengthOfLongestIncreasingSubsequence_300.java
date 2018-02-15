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
public class lengthOfLongestIncreasingSubsequence_300 {
    // 53.90%
    // O(n2) time, O(n) space
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0)   return 0;
            int[] dp = new int[nums.length];
            dp[0] = 1;
            for(int i=1; i<nums.length; i++){
                for(int j=0; j<i; j++){
                    if(nums[j] < nums[i]){
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += 1;
            }
            return dp[nums.length-1];
        }
    }
}
