/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class fourSum_018 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            int len = nums.length;
            if(len < 4)   return res;
            Arrays.sort(nums);
            if(nums[len-1] + nums[len-2] + nums[len-3] + nums[len-4] < target)  return res;
            
            for(int i=0; i<len-3; i++){
                if(i==0 || (i>0 && nums[i-1]!=nums[i])){
                    if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target)  break;
                    for(int j=i+1; j<len-2; j++){
                        if(j==i+1 || (j>i+1 && nums[j-1]!=nums[j])){
                            if(nums[j] + nums[j+1] + nums[j+2] + nums[i] > target)  break;
                            int lo=j+1, hi=len-1, sum=target-nums[i]-nums[j];
                            while(lo<hi){
                                if(nums[hi] + nums[hi-1] + nums[hi-2] + nums[hi-2] < target)  break;
                                if(nums[lo] + nums[hi] == sum){
                                    res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                                    while(lo<hi && nums[lo]==nums[lo+1])    lo++;
                                    while(lo<hi && nums[hi]==nums[hi-1])    hi--;
                                    lo++;   hi--;
                                }
                                else if(nums[lo] + nums[hi] < sum){
                                    while(lo<hi && nums[lo]==nums[lo+1])    lo++;
                                    lo++;
                                }
                                else{
                                    while(lo<hi && nums[hi]==nums[hi-1])    hi--;
                                    hi--;
                                }
                            }
                        }
                    }
                }
            }
            return res;
            
        }
    }
}
