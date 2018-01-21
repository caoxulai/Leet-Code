/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashMap;

/**
 *
 * @author Bryce
 */
public class lengthOfLongestSubstring_003 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res=0;
            if (s == null || s.length() == 0) return res;
            
            HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
            boolean duplicated = false;
            int start=0, end=0;
            while(end<s.length()){
                char c = s.charAt(end++);
                cnt.put(c, cnt.getOrDefault(c, 0)+1);
                if(cnt.get(c)>1)   duplicated = true;
                
                while(duplicated){
                    char cs = s.charAt(start++);
                    cnt.put(cs, cnt.get(cs)-1);
                    if(cnt.get(cs)==1)   duplicated = false;
                }
                res = Math.max(res, end-start);
            }
            return res;
        }
    }
}
