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
public class subsets_078 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for(int n: nums){
                List<List<Integer>> temp = new ArrayList<>(res);
                for(List<Integer> list: res){
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(n);
                    temp.add(newList);
                }
                res = temp;
            }
            return res;
        }
    }
}
