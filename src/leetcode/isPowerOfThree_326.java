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
public class isPowerOfThree_326 {
    class Solution {
        public boolean isPowerOfThree(int n) {
            int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
            return n>0 && maxPowerOfThree%n==0;
        }
    }
}
