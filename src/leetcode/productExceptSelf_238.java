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
public class productExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length==0)  return null;
        int[] res = new int[nums.length];
        for(int i=0, temp=1; i<nums.length; i++){
            res[i] = temp;
            temp *= nums[i];
        }
        
        for(int i=nums.length-1, temp=1; i>=0; i--){
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}
