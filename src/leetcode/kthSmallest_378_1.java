/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author I852047
 */
public class kthSmallest_378_1 {
    // 66.16%
    // special binary search, use range as search space instead of index
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int row = matrix.length;
            int col = matrix[0].length;
            int lo = matrix[0][0];
            int hi = matrix[row-1][col-1];
            while(lo < hi){
                int mid = lo + (hi-lo)/2;
                int count = 0;
                for(int[] mRow: matrix){
                    for(int n: mRow){
                        if(n <= mid){
                            count++;
                            if(count >= k) break;
                        }
                        else break;
                    }
                }
                if(count >= k)  hi = mid;
                else    lo = mid + 1;
            }
            return lo;
        }
    }
}
