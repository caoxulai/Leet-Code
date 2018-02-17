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
public class findUnsortedSubarray_581_1 {
    // 84.18%
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int l=nums.length-1, r=0;
            int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
            boolean searchMin=false, searchMax=false;
            
            for(int i=1; i<nums.length; i++){
                if(!searchMin){
                    if(nums[i-1] > nums[i]){
                        searchMin = true;
                        min = nums[i];
                    }
                }
                else
                    min = Math.min(min, nums[i]);
            }
            // searchMin not changed, meaning the array is already sorted
            if(!searchMin)  return 0;
            
            for(int i=0; i<nums.length; i++){
                if(nums[i] > min){
                    l = i;
                    break;
                }
            }
            
            for(int i=nums.length-2; i>=0; i--){
                if(!searchMax){
                    if(nums[i] > nums[i+1]){
                        searchMax = true;
                        max = nums[i];
                    }
                }
                else
                    max = Math.max(max, nums[i]);
            }
            
            for(int i=nums.length-1; i>=0; i--){
                if(nums[i] < max){
                    r = i;
                    break;
                }
            }
            
            // unsorted must exist, no need to check if r>l
            return r-l+1;
        }
    }
}
