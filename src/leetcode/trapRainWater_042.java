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
public class trapRainWater_042 {
    class Solution {
        public int trap(int[] height) {
            int water=0;
            int l = 0, r = height.length-1;
            int leftMax = 0, rightMax = 0;
            while(l < r){
                if(height[l] < height[r]){
                    leftMax = Math.max(leftMax, height[l]);
                    water += leftMax - height[l++];
                }else{
                    rightMax = Math.max(rightMax, height[r]);
                    water += rightMax - height[r--];
                }
            }
            return water;
        }
    }
}
