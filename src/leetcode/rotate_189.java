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
public class rotate_189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, nums.length-1);
        }
        
        private void reverse(int[] nums, int i, int j){
            while(i<j){
                int t = nums[i];
                nums[i++] = nums[j];
                nums[j--] = t;
            }
        }
    }
}
