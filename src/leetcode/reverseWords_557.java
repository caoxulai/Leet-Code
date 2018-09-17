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
public class reverseWords_557 {
    class Solution {
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(reverseWord(word)).append(" ");
            }
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }


        private String reverseWord(String s) {
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString();
        }
    }
}
