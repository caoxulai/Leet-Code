package leetcode;

public class coinChange518 {
    public int change(int amount, int[] coins) {
        // i - first i coins used regardless of number used
        // j - total amount
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;

        for(int i=0; i<coins.length; i++) {
            for(int j=0; j<=amount; j++){
                dp[i+1][j] = dp[i][j] + (coins[i]<=j ? dp[i+1][j-coins[i]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
