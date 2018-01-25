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
public class subsetsWithDup_090 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(res, new ArrayList<>(), nums, 0);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
            res.add(new ArrayList<>(list));
            for(int i=start; i<nums.length; i++){
                if(i>start && nums[i] == nums[i-1]) continue;
                list.add(nums[i]);
                backTrack(res, list, nums, i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
