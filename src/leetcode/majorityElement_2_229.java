/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class majorityElement_2_229 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if(nums==null || nums.length==0) return res;
            
            int maj1=nums[0], maj2=nums[0], count1=0, count2=0;
            for(int n : nums){
                if(n == maj1){
                    count1++;
                }else if(n == maj2){
                    count2++;
                }else if(count1==0){
                    maj1 = n;
                    count1++;
                }else if(count2==0){
                    maj2 = n;
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }
            
            count1 = 0;
            count2 = 0;
            for(int n : nums){
                if(n == maj1)   count1++;
                else if(n == maj2)  count2++;
            }
            
            if(count1 > nums.length/3)  res.add(maj1);
            if(count2 > nums.length/3)  res.add(maj2);
            return res;
        }
    }
}
