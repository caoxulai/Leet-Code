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
public class searchInRotatedSortedArray_081 {
    class Solution {
        public boolean search(int[] nums, int target) {
            if(nums==null || nums.length==0)    return false;
            int lo=0, hi=nums.length-1;
            while(lo<hi){
                int mid = lo + (hi-lo)/2;
                if(nums[mid] == target) return true;
                while(lo < mid && nums[lo]==nums[mid])
                    lo++;
                
                if(nums[lo] <= nums[mid]){
                    // add = to make sure to increase lo as nums[lo](nums[mid]) was checked
                    if(nums[lo] <= target && target < nums[mid])
                        hi = mid - 1;
                    else
                        lo = mid + 1;
                }
                else{
                    if(nums[mid] < target && target <= nums[hi])
                        lo = mid + 1;
                    else
                        hi = mid - 1;
                }
            }
            return nums[lo]==target;
        }
    }
}
