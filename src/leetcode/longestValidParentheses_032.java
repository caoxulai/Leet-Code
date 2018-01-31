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
public class longestValidParentheses_032 {
    class Solution {
        public int longestValidParentheses(String s) {
            int[] dp = new int[s.length()];
            Stack<Integer> stack = new Stack<>();
            int max=0;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(')    stack.push(i);
                else if(c == ')' && !stack.isEmpty()){
                    int left = stack.pop();
                    dp[i] = i - left + 1 + (left>0?dp[left-1]:0);
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }
    }
}
