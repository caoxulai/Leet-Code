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
public class majorityElement_169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int pre = 0;
            for(int n: nums){
                if(count == 0){
                    pre = n;
                    count++;
                }
                else{
                    if(pre == n){
                        count++;
                    }else{
                        count--;
                    }
                }
            }
            return pre;
        }
    }
}
