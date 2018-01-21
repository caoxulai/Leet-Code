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
public class findMinMoves_517 {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int m:machines){
            sum += m;
        }
        if(sum % machines.length != 0) return -1;
        int avg = sum/machines.length;
        
        int min = 0, cur = 0;
        for(int m:machines){
            int diff = m - avg;
            min = Math.max(min, diff);
            cur += diff;
            min = Math.max(min, Math.abs(cur));
        }
        return min;
    }
}
