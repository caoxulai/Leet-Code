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
public class canPartition_416 {
    // Exceeded Limited Runtime
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num: nums)  sum += num;
            if((sum & 1) == 1)    return false;
            
            return backTrack(nums, sum/2, 0);
        }
        
        private boolean backTrack(int[] nums, int sum, int start){
            if(sum == 0)    return true;
            if(sum < 0)     return false;
            for(int i=start; i<nums.length; i++){
                if(backTrack(nums, sum-nums[i], i+1))   return true;
            }
            return false;
        }
    }
}
