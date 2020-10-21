/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashMap;

/**
 *
 * @author Bryce
 */
public class coinChange_322_2 {
    public static void main(String [] args)    {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins,73));
    }

    private static int[] ans;

    public static int coinChange(int[] coins, int amount) {
        ans = new int[amount+1];
        ans[0] = 0;
        for(int total=1; total<=amount; total++){
            ans[total] = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= total && ans[total-coin] != -1)
                    ans[total] = Math.min(ans[total], ans[total-coin] + 1);
            }
            if(ans[total] == Integer.MAX_VALUE)     ans[total] = -1;
        }
        return ans[amount];
    }
}
