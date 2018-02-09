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
public class maxCoins_312 {
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] balloons = new int[n+2];
            for(int i=1; i<=n; i++){
                balloons[i] = nums[i-1];
            }
            balloons[0] = balloons[n+1] = 1;
            
            int[][] memo = new int[n+2][n+2];
            return burst(memo, balloons, 0, n+1);
        }
        
        private int burst(int[][] memo, int[] balloons, int left, int right){
            if(left + 1 == right)   return 0;
            if(memo[left][right] > 0)   return memo[left][right];
            
            int res = 0;
            for(int i=left+1; i<right; i++){
                res = Math.max(res, balloons[i] * balloons[left] * balloons[right] +
                        burst(memo, balloons, left, i) + burst(memo, balloons, i, right));
            }
            return res;
        }
    }
}
