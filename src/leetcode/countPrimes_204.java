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
public class countPrimes_204 {
    class Solution {
        public int countPrimes(int n) {
            int res = 0;
            boolean[] notPrime = new boolean[n+1];
            for(int i=2; i<n; i++){
                if(!notPrime[i]){
                    res++;
                    for(int j=2; i*j<=n; j++){
                        notPrime[i*j] = true;
                    }
                }
            }
            return res;
        }
    }
}
