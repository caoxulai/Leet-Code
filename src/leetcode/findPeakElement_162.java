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
public class findPeakElement_162 {
    // binary search
    class Solution {
        public int findPeakElement(int[] nums) {
            int lo=0, hi=nums.length-1;
            while(lo < hi){
                int mid = lo + (hi-lo)/2;
                if(nums[mid] < nums[mid+1])    lo = mid+1;
                else hi = mid;
            }
            return lo;
        }
    }
}
