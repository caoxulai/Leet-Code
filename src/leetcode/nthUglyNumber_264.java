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
public class nthUglyNumber_264 {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            int two=0, three=0, five=0;
            for(int i=1; i<n; i++){
                while(ugly[two] * 2 <= ugly[i-1])   two++;
                while(ugly[three] * 3 <= ugly[i-1])   three++;
                while(ugly[five] * 5 <= ugly[i-1])   five++;
                
                int min = Math.min(2*ugly[two], 3*ugly[three]);
                min = Math.min(min, 5*ugly[five]);
                ugly[i] = min;
            }
            return ugly[n-1];
        }
    }
}
