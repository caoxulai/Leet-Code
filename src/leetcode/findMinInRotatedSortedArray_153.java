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
public class findMinInRotatedSortedArray_153 {
    class Solution {
        public int findMin(int[] nums) {
            int lo=0, hi=nums.length-1;
            int min = nums[lo];
            while(lo<=hi){
                int mid = lo + (hi-lo)/2;
                while(lo < mid && nums[lo]==nums[mid])
                    lo++;
                
                if(nums[lo] <= nums[mid]){
                    min = Math.min(min, nums[lo]);
                    lo = mid + 1;
                }
                else{
                    min = Math.min(min, nums[mid]);
                    hi = mid - 1;
                }
            }
            return min;
        }
    }
}
