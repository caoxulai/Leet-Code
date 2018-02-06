/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author I852047
 */
public class rob_213 {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
        }
        
        private int rob(int[] nums, int lo, int hi) {
            int a=0, b=0;
            for(int i=lo; i<=hi; i++){
                int c = Math.max(a + nums[i], b);
                a = b;
                b = c;
            }
            return b;
        }
    }
}
