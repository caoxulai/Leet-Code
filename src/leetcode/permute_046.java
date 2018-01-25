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
public class permute_046 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backTrack(res, new ArrayList<>(), nums);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums){
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
            }
            else{
                for(int i=0; i<nums.length; i++){
                    if(list.contains(nums[i])) continue;
                    list.add(nums[i]);
                    backTrack(res, list, nums);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
