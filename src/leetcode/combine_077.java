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
public class combine_077 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            backTrack(res, new ArrayList<>(), n, k, 1);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, int n, int k, int start){
            if(list.size() == k){
                res.add(new ArrayList<>(list));
            }
            else{
                for(int i=start; i<=n; i++){
                    list.add(i);
                    backTrack(res, list, n, k, i+1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
