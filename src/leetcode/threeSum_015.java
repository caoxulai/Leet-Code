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
public class threeSum_015 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            
            for(int i=0; i<nums.length-2; i++){
                if(i!=0 && nums[i] == nums[i-1])    continue;
                int start=i+1, end=nums.length-1;
                while(start < end){
                    if(nums[i] + nums[start] + nums[end] == 0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        res.add(list);
                        while(nums[start] == nums[++start] && start < end){}
                        while(nums[end] == nums[--end] && start < end){}
                    }
                    else if(nums[i] + nums[start] + nums[end] < 0){
                        while(nums[start] == nums[++start] && start < end){}
                    }
                    else
                        while(nums[end] == nums[--end] && start < end){}
                }
            }
            return res;
        }
    }
}
