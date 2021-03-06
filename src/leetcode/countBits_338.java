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
public class countBits_338 {
    // my intuitive solution, find the pattern for 2-bit integers.
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num+1];
            int size=1;
            for(int i=1; i<=num; i++){
                if(i == 2 * size)
                    size *= 2;
                res[i] = res[i-size] + 1;
            }
            return res;
        }
    }
}
