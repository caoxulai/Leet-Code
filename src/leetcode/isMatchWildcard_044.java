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
public class isMatchWildcard_044 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int a=0, b=0, lastStar=-1, back=0;
            while(a<s.length()){
                if(b<p.length() && (p.charAt(b) == '?' || s.charAt(a) == p.charAt(b))){
                    a++;
                    b++;
                }else if(b<p.length() && p.charAt(b) == '*'){
                    lastStar = b;
                    back = a;
                    b++;
                }else if(lastStar != -1){
                    b = lastStar+1;
                    back++;
                    a = back;
                }else
                    return false;
            }
            while(b < p.length() && p.charAt(b) == '*')
                b++;
            return b == p.length();
        }
    }
}
