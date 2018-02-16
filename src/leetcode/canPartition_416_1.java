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
public class canPartition_416_1 {
    // 89.73%
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num: nums)  sum += num;
            if((sum & 1) == 1)    return false;
            sum /= 2;
            
            boolean[] dp = new boolean[sum+1];
            dp[0] = true;
            for(int num: nums){
                for(int i=sum; i>0; i--){
                    if(i >= num)
                        dp[i] = dp[i] || dp[i-num];
                }
                if(dp[sum]) return true;
            }
            return dp[sum];
        }
    }
}
