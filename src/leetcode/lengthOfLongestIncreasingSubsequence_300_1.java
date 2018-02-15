/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Arrays;

/**
 *
 * @author Bryce
 */
public class lengthOfLongestIncreasingSubsequence_300_1 {
    // 71.80%
    // O(nlogn) time, o(n) space    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
    
    public static int lengthOfLIS(int[] nums) {
        int[] array = new int[nums.length];
        int max=0;
        for(int num: nums){
            // binarySearch(int[] a, int fromIndex, int toIndex, int key)
            int index = Arrays.binarySearch(array, 0, max, num);
            if(index < 0)   index = -(index+1);
            array[index] = num;
            max = Math.max(max, index+1);
        }
        return max;
    }
}
