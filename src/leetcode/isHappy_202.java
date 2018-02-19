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
public class isHappy_202 {
    // Floyd Cycle detection algorithm
    class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;
            do{
                slow = squareSum(slow);
                fast = squareSum(fast);
                fast = squareSum(fast);
            }while(slow != fast);
            return slow==1;
        }
        
        private int squareSum(int n){
            int sum = 0;
            while(n!=0){
                int t = n%10;
                sum += t * t;
                n /= 10;
            }
            return sum;
        }
    }
}
