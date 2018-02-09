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
public class countBits_338_2 {
    // shifting numbers.
    // right shit 1 bit, the total number of 1 bits only be 1 less if the lowest bit was 1.
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num+1];
            for(int i=1; i<=num; i++){
                res[i] = res[i>>1] + (i&1);
            }
            return res;
        }
    }
}
