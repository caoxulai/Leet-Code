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
public class longestPalindrome_005 {
    public String longestPalindrome(String s) {
        int start=0, end=0;
        for(int i=0; i<s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end-start){
                start = i-(len-1)/2;
                end = start + len;
            }
        }
        return s.substring(start, end);
    }
    
    private int expand(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
