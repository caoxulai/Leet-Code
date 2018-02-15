/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class reconstructQueue_406 {
    // 26.28%
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    (a, b) -> {
                        if(a[0] != b[0])    return b[0] - a[0];
                        else return a[1] - b[1];
                    });
            
            for(int[] p: people)    queue.offer(p);
            
            List<int[]> newQueue = new ArrayList<>();
            while(!queue.isEmpty()){
                int[] p = queue.poll();
                newQueue.add(p[1], p);
            }
            
            int[][] res = new int[newQueue.size()][2];
            for(int i=0; i<newQueue.size(); i++){
                res[i] = newQueue.get(i);
            }
            return res;
        }
    }
}
