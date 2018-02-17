/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Stack;

/**
 *
 * @author Bryce
 */
public class findUnsortedSubarray_581 {
    // 7.87%
    // stack, O(n) time, O(n) space
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int l = nums.length-1, r=0;
            for(int i=0; i<nums.length; i++){
                while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
                    l = Math.min(l, stack.pop());
                stack.push(i);
                if(l == 0)  break;
            }
            
            stack.clear();
            for(int i=nums.length-1; i>=0; i--){
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
                    r = Math.max(r, stack.pop());
                stack.push(i);
                if(r == nums.length-1)  break;
            }
            
            return l<r? r-l+1 : 0;
        }
    }
}
