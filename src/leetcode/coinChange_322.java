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
public class coinChange_322 {
    public static void main(String [] args)    {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins,73));
    }
    
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0)     return 0;
        if(amount < 0)      return -1;
        if(map.containsKey(amount))     return map.get(amount);
        int min = Integer.MAX_VALUE;
        for(int coin: coins){
            int m = coinChange(coins, amount-coin);
            if(m==-1)   continue;
            min = Math.min(min, 1+m);
        }
        min = min == Integer.MAX_VALUE? -1: min;
        map.put(amount, min);
        return min;
    }    
}
