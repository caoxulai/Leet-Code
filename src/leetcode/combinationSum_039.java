/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class combinationSum_039 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            backTrack(res, new ArrayList<>(), candidates, target, 0);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start){
            if(target == 0){
                res.add(new ArrayList<>(list));
            }
            else if(target>0){
                for(int i=start; i<candidates.length; i++){
                    list.add(candidates[i]);
                    backTrack(res, list, candidates, target-candidates[i], i);  // not i + 1 because we can reuse same elements
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
