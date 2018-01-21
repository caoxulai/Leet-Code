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
public class findSubstringWithConcatenation_030 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if(words.length==0) return res;
            HashMap<String, Integer> map = new HashMap<>();
            for(String word: words){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            int wl=words[0].length();
            int totalLength = words.length * wl;
            for(int i=0; i<wl; i++){
                int count = map.size();
                HashMap<String, Integer> currMap = new HashMap<>();
                for(int start=i, cur=i; cur+wl <= s.length(); cur += wl){
                    String temp = s.substring(cur, cur+wl);
                    if(map.containsKey(temp)){
                        currMap.put(temp, currMap.getOrDefault(temp, 0) + 1);
                        if(currMap.get(temp) == map.get(temp))  count--;
                        
                        // System.out.println("start " + start + " cur " +cur+ " temp " + temp);
                        
                        while(currMap.get(temp) > map.get(temp)){
                            // System.out.println("currMap.get(temp) " + currMap.get(temp) + " map.get(temp) " +map.get(temp)+ " start " + start);
                            String first = s.substring(start, start+wl);
                            currMap.put(first, currMap.get(first) - 1);
                            if(currMap.get(first) < map.get(first)) count++;
                            start += wl;
                        }
                        if(count==0){
                            res.add(start);
                            String first = s.substring(start, start+wl);
                            currMap.put(first, currMap.get(first) - 1);
                            count++;
                            start += wl;
                        }
                    }
                    else{
                        currMap.clear();
                        count = map.size();
                        start = cur + wl;
                    }
                    if(start+totalLength>s.length())
                        break;
                }
            }
            return res;
        }
    }
}
