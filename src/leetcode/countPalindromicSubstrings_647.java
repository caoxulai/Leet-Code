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
public class countPalindromicSubstrings_647 {
    // 65.64% 12ms
    // Similar idea like Problem 005 longest palindrome
    class Solution {
        int count = 0;
        public int countSubstrings(String s) {
            for(int i=0; i<s.length(); i++){
                expand(s, i, i);
                expand(s, i, i+1);
            }
            return count;
        }
        
        private void expand(String s, int l, int r){
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
    }
}
