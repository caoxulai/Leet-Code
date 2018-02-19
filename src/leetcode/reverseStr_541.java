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
public class reverseStr_541 {
    class Solution {
        public String reverseStr(String s, int k) {
            StringBuilder sb = new StringBuilder(s);
            for(int i=0; i<s.length(); i += 2*k){
                reverse(sb, i, Math.min(i+k-1, s.length()-1));
            }
            return sb.toString();
        }
        
        private void reverse(StringBuilder sb, int i, int j){
            while(i<j){
                char c = sb.charAt(i);
                sb.setCharAt(i++, sb.charAt(j));
                sb.setCharAt(j--, c);
            }
        }
    }
}
