/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class topKFrequent_347 {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> count = new HashMap<>();
            for(int n: nums){
                count.put(n, count.getOrDefault(n, 0)+1);
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> count.get(a)-count.get(b));
            for(int n: count.keySet()){
                queue.offer(n);
                if(queue.size()>k)  queue.poll();
            }
            List<Integer> res = new ArrayList<>();
            while(!queue.isEmpty()){
                res.add(0, queue.poll());
            }
            return res;
        }
    }
}
