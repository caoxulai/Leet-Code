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
import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class topKFrequentWords_692_1 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            HashMap<String, Integer> count = new HashMap<>();
            
            for(String word: words){
                int cnt = count.getOrDefault(word, 0);
                count.put(word, cnt+1);
            }
            
            
            PriorityQueue<String> queue = new PriorityQueue<>(
                    (a, b) -> count.get(a)!= count.get(b)? count.get(a)-count.get(b): a.compareTo(b));
            for(String word: count.keySet()){
                queue.offer(word);
                if(queue.size() > k)
                    queue.poll();
            }
            
            List<String> res = new ArrayList<>();
            while(!queue.isEmpty()){
                res.add(0, queue.poll());
            }
            return res;
        }
    }
}
