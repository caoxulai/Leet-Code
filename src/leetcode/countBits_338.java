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
    class Solution {
        public int[] countBits(int num) {
            int[] res = new int[num+1];
            int size=1;
            for(int j=1; j<=num; j++){
                if(j == 2 * size)
                    size *= 2;
                res[j] = res[j-size] + 1;
            }
            return res;
        }
    }
}
