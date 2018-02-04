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
public class findDuplicate_287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            int slow=0, fast=0;
            while(slow == 0 || nums[slow] != nums[fast]){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            
            slow = 0;
            while(nums[slow] != nums[fast]){
                slow = nums[slow];
                fast = nums[fast];
            }
            return nums[slow];
        }
    }
}
