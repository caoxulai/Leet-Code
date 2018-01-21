/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findAnagrams_438 {
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
            
            HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();
            for(char c : p.toCharArray()){
                cnt.put(c, cnt.getOrDefault(c, 0)+1);
            }
            int letters = cnt.size();
            int start=0, end=0;
            while(end<s.length()){
                char c = s.charAt(end++);
                if(cnt.containsKey(c)){
                    cnt.put(c, cnt.get(c)-1);
                    if(cnt.get(c)==0)   letters--;
                }
                while(letters==0){
                    if(end-start == p.length()){
                        res.add(start);
                    }
                    
                    char cs = s.charAt(start++);
                    if(cnt.containsKey(cs)){
                        cnt.put(cs, cnt.get(cs)+1);
                        if(cnt.get(cs)>0)   letters++;
                    }
                }
            }
            return res;
        }
    }
}
