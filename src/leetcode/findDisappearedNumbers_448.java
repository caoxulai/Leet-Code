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
public class findDisappearedNumbers_448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            for(int i=0; i<n; i++){
                int index = nums[i] % n;
                nums[index] += n;
            }
            
            List<Integer> res = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(nums[i] < n)     res.add(i);
            }
            return res;
        }
    }
}