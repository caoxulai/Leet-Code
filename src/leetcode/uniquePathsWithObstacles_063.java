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
public class uniquePathsWithObstacles_063 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if(obstacleGrid == null || obstacleGrid.length<1 || obstacleGrid[0].length<1 || obstacleGrid[0][0] == 1)
                return 0;
            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;
            
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(i==0){
                        if(obstacleGrid[i][j]==1)
                            break;
                        dp[j] = 1;
                    }
                    else{
                        if(obstacleGrid[i][j]==1)
                            dp[j] = 0;
                        else
                            dp[j] += j>0?dp[j-1] : 0;
                    }
                }
            }
            return dp[n-1];
            
        }
    }
}
