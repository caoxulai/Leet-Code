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
public class singleNumber_137 {
    public static void main(String [] args){
        int[] nums = new int[]{222, 222, 3333, 3333, 3333, 5555, 5555, 5555};
        System.out.println(singleNumber(nums));
    }
    
    public static int singleNumber(int[] nums){
        int x2=0, x1=0;
        for(int n: nums){
            x2 ^= x1 & n;
            x1 ^= n;
            int mask = ~(x2 & x1);
            x2 &= mask;
            x1 &= mask;
        }
        return x2;
        
    }
}
