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
public class isAnagram_242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length())    return false;
            int[] map = new int[128];
            for(int i=0; i<s.length(); i++){
                map[s.charAt(i)]++;
                map[t.charAt(i)]--;
            }
            for(int j=1; j<128; j++){
                if(map[j] != 0) return false;
            }
            return true;
        }
    }
}
