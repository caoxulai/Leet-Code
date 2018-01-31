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
public class longestValidParentheses_032_1 {
    // using 2 counters
    class Solution {
        public int longestValidParentheses(String s) {
            int left=0, right=0, max=0;
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '(')    left++;
                else if(c == ')')   right++;
                
                if(left==right) max = Math.max(max, 2*left);
                else if(left<right){
                    left=0; right=0;
                }
            }
            
            left=0; right=0;
            for(int i=s.length()-1; i>=0; i--){
                char c = s.charAt(i);
                if(c == '(')    left++;
                else if(c == ')')   right++;
                
                if(left==right) max = Math.max(max, 2*left);
                else if(left>right){
                    left=0; right=0;
                }
            }
            return max;
        }
    }
}
