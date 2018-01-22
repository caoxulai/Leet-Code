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
public class wordBreak_2_140 {
    HashMap<String, List<String>> found = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(found.containsKey(s))    return found.get(s);
        if(wordDict.contains(s)){
            res.add(s);
        }
        for(int i=1; i<=s.length(); i++){
            String t = s.substring(0, i);
            if(wordDict.contains(t)){                
                List<String> next = wordBreak(s.substring(i), wordDict);
                if(next.size() != 0){
                    for(String n : next){
                        String temp = t + " " + n;
                        res.add(temp);
                    }
                }
            }
        }
        found.put(s, res);
        return res;
    }
}
