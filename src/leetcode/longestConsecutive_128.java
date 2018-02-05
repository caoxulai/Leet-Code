/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashSet;

/**
 *
 * @author Bryce
 */
public class longestConsecutive_128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            int max=0;
            HashSet<Integer> set = new HashSet<>();
            for(int n: nums){
                set.add(n);
            }
            
            for(int n: nums){
                if(!set.contains(n-1)){
                    int cur = 0;
                    while(set.contains(n)){
                        cur++;
                        n++;
                    }
                    max = Math.max(max, cur);
                }
            }
            return max;
        }
    }
}
