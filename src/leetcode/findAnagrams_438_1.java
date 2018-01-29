/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findAnagrams_438_1 {
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
            
            int[] cnt = new int[128];
            for(char c : p.toCharArray()){
                cnt[c]++;
            }
            int len = p.length();
            int start=0, end=0;
            while(end<s.length()){
                char c = s.charAt(end++);
                if(cnt[c]-- > 0) len--;
                
                while(len==0){
                    if(end-start == p.length())
                        res.add(start);
                    char cs = s.charAt(start++);
                    if(cnt[cs]++ == 0)  len++;
                }
            }
            return res;
        }
    }
}
