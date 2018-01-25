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
public class permuteUnique_047 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
            if(list.size() == nums.length){
                res.add(new ArrayList<>(list));
            }
            else{
                for(int i=0; i<nums.length; i++){
                    if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                    list.add(nums[i]);
                    used[i] = true;
                    backTrack(res, list, nums, used);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
