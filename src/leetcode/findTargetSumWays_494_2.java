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
public class findTargetSumWays_494_2 {
    // 91.06%
    // dp solution, translate this problem to subsetSum problem
    // sum(P) - sum(N) = target
    // sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N) 
    // 2*sum(P) = target + sum
    // This problem now is to find a subset which sums to (target+sum)/2
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for(int num: nums)  sum += num;
            if(S > sum || S<-sum || (sum+S)%2==1)   return 0;
            return subsetSum(nums, (sum+S)/2);
        }
        
        private int subsetSum(int[] nums, int sum){
            int[] ways = new int[sum+1];
            ways[0] = 1;
            for(int num: nums){
                for(int i=sum; i>=num; i--)
                    ways[i] += ways[i-num];
            }
            return ways[sum];
        }
    }
}
