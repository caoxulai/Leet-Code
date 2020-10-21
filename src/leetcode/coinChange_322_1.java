package leetcode;

import java.util.Arrays;

public class coinChange_322_1 {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        memo = new int[amount+1];
        Arrays.fill(memo, 0);
        return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        if(amount < 0)     return -1;
        else if (amount == 0)   return 0;
        if(memo[amount] != 0)   return memo[amount];
        if(contains(coins, amount))     return 1;
        int ans = Integer.MAX_VALUE;
        for(int coin : coins) {
            int rem = helper(coins, amount - coin);
            if(rem != -1)   ans = Math.min(ans, rem);
        }
        memo[amount] = ans==Integer.MAX_VALUE ? -1 : ans + 1;
        return memo[amount];
    }

    private boolean contains(int[] coins, int amount) {
        int lo = 0, hi = coins.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(coins[mid] == amount)    return true;
            else if(coins[mid] > amount)    hi = mid - 1;
            else    lo = mid + 1;
        }
        return false;
    }
}
