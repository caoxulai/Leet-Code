/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author Bryce
 */
public class maxProduct_152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int maxPre=1, minPre=1;
            int maxSofar = Integer.MIN_VALUE;
            for(int n:nums){
                int maxHere = Math.max(n, Math.max(maxPre*n, minPre*n));
                int minHere = Math.min(n, Math.min(maxPre*n, minPre*n));
                maxSofar = Math.max(maxSofar, maxHere);
                maxPre = maxHere;
                minPre = minHere;
            }
            return maxSofar;
        }
    }
}
