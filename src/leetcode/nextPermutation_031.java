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
public class nextPermutation_031 {
    class Solution {
        public void nextPermutation(int[] nums) {
            if(nums == null || nums.length<2)   return;
            int p = nums.length-2;
            while(p>=0 && nums[p]>=nums[p+1]){
                p--;
            }
            if(p<0){
                reverse(nums, 0, nums.length-1);
            }
            else{
                int q = nums.length-1;
                while(nums[p] >= nums[q]){
                    q--;
                }
                swap(nums, p, q);
                reverse(nums, p+1, nums.length-1);
            }
        }
        
        private void swap(int[] nums, int i, int j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
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
