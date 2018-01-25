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
public class combinationSum2_040 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            backTrack(res, new ArrayList<>(), candidates, target, 0);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
            if(target == 0){
                res.add(new ArrayList<>(list));
            }
            else if(target>0){
                for(int i=start; i<candidates.length; i++){
                    if(i>start && candidates[i]==candidates[i-1])   continue;
                    list.add(candidates[i]);
                    backTrack(res, list, candidates, target-candidates[i], i+1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
