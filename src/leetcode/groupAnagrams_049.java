/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class groupAnagrams_049 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if(strs == null || strs.length==0)    return new ArrayList<>();
            HashMap<String, List<String>> map = new HashMap<>();
            for(String s: strs){
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if(!map.containsKey(key))   map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
}
