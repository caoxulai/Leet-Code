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
public class isPowerOfTwo_231 {
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n>0 && (n&(n-1))==0;
        }
    }
}
