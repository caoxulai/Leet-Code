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
public class canJump_055 {
    class Solution {
        public boolean canJump(int[] nums) {
            int len = nums.length;
            int max = 0;
            for(int i=0; i<=max; i++){
                max = Math.max(max, i+nums[i]);
                if(max >= len-1)  return true;
            }
            return false;
        }
    }
}
