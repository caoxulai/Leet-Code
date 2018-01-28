/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class topKFrequentWords_692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> keyToCount = new HashMap<>();
            HashMap<Integer, List<String>> countToKeys = new HashMap<>();
            
            for(String key: words){
                int count = keyToCount.getOrDefault(key, 0);
                keyToCount.put(key, count+1);
                if(countToKeys.containsKey(count+1))
                    countToKeys.get(count+1).add(key);
                else{
                    List<String> list = new ArrayList<>();
                    list.add(key);
                    countToKeys.put(count+1, list);
                }
                if(count > 0){
                    countToKeys.get(count).remove(key);
                    if(countToKeys.get(count).isEmpty())
                        countToKeys.remove(count);
                }
            }
            
            List<String> res = new ArrayList<>();
            for(int i=words.length; i>=0; i--){
                if(countToKeys.containsKey(i)){
                    Collections.sort(countToKeys.get(i));
                    res.addAll(countToKeys.get(i));
                    if(res.size() >= k)
                        break;
                }
            }
            res = res.subList(0, k);
            return res;
        }
    }
}
