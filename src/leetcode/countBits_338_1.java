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
public class countBits_338_1 {
    // bit operation. n&(n-1) to drops the lowest set bit.
    // Therefore, n&(n-1) < n. This also guarantee res[n&(n-1)] is calculated 
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num+1];
            for(int i=1; i<=num; i++){
                res[i] = res[i&(i-1)] + 1;
            }
            return res;
        }
    }
}
