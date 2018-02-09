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
public class hammingDistance_461_1 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int res = 0;
            while(x!=0 || y!=0){
                res += (x&1)^(y&1);
                x >>= 1;
                y >>= 1;
            }
            return res;
        }
    }
}
