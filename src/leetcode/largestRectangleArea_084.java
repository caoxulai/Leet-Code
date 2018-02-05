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
public class largestRectangleArea_084 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<=heights.length; i++){
                int h = i==heights.length? 0: heights[i];
                if(stack.isEmpty() || h >= heights[stack.peek()]){
                    stack.push(i);
                }else{
                    int last = stack.pop();
                    int width = i - 1 - (stack.isEmpty()? (-1): stack.peek());
                    max = Math.max(max, width * heights[last]);
                    i--;
                }
            }
            return max;
        }
    }
}
