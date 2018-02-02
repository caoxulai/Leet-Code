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
public class searchRange_034 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums==null || nums.length==0)    return new int[]{-1, -1};
            
            // Search for the left one
            int lo=0, hi=nums.length-1;
            while(lo<hi){
                int mid = lo + (hi-lo)/2;
                if(nums[mid] < target)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            if(nums[lo] != target)  return new int[]{-1, -1};
            int low = lo;
            

            // Search for the right one
            hi=nums.length-1;       // We don't have to set i to 0 the second time.
            while(lo<hi){
                int mid = lo + (hi-lo)/2 + 1;   // Make mid biased to the right
                if(nums[mid] > target)
                    hi = mid - 1;
                else
                    lo = mid;       // So that this won't make the search range stuck.
            }
            int high = lo;
            return new int[]{low, high};
        }
    }
}
