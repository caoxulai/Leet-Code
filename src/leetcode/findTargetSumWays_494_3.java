package leetcode;

public class findTargetSumWays_494_3 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num: nums)  sum += num;
        if(S > sum || S<-sum || (sum+S)%2==1)   return 0;

        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] += 1;
        dp[0][-nums[0] + 1000] += 1;

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<2001; j++) {
                if(dp[i-1][j] != 0) {
                    dp[i][j + nums[i]] += dp[i-1][j];
                    dp[i][j - nums[i]] += dp[i-1][j];
                }
            }
        }

        return dp[nums.length-1][S+1000];
    }
}
