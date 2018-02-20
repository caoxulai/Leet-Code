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
public class longestSubstring_395 {
    // 82.18%
    public static void main(String [] args){
        System.out.println(longestSubstring("aaabb", 3));        
    }
    
    public static int longestSubstring(String s, int k) {
        if(k == 0 || s.length()==0 || s.length()<k)  return 0;
        if(k == 1)  return s.length();
        int[] count = new int[128];
        for(char c: s.toCharArray())    count[c]++;
        char c = 0;
        while(c < 128){
            if(count[c] > 0 && count[c] < k)    break;
            c++;
        }
        if(c == 128)    return s.length();
        
        String t = c + "";
        int max = 0;
        String[] strs = s.split(t);
        for(String str: strs){
            int len = longestSubstring(str, k);
            max = Math.max(max, len);
        }
        return max;
    }
}
