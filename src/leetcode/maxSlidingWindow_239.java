/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author Bryce
 */
public class maxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i=0; i<nums.length; i++){
            if(!deque.isEmpty() && deque.peek() <= i-k){
                deque.poll();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            
            if(i+1>=k){
                res[i-k+1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
