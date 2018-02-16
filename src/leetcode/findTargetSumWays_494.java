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
public class findTargetSumWays_494 {
    // 34.24%
    // back tracking
    class Solution {
        int count = 0;
        public int findTargetSumWays(int[] nums, int S) {
            backTrack(nums, S, 0);
            return count;
        }
        
        private void backTrack(int[] nums, int sum, int i){
            if(i == nums.length){
                if(sum == 0)    count++;
                return;
            }
            
            backTrack(nums, sum-nums[i], i+1);
            backTrack(nums, sum+nums[i], i+1);
        }
    }
}
