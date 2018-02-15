/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class getSkyline_218 {
    class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> height = new ArrayList<>();
            for(int[] building: buildings){
                height.add(new int[]{building[0], building[2]});
                height.add(new int[]{building[1], -building[2]});
            }
            Collections.sort(height,
                    (a, b) -> {
                        if(a[0] != b[0])
                            return a[0] - b[0];
                        // to make sure the left edge gets in first.
                        return b[1] - a[1];
                    });
            
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
            queue.add(0);
            List<int[]> res = new ArrayList<>();
            int pre = 0;
            for(int[] h : height){
                if(h[1]>=0) queue.offer(h[1]);
                else queue.remove(-h[1]);
                
                int cur = queue.peek();
                if(pre != cur){
                    res.add(new int[]{h[0], cur});
                    pre = cur;
                }
            }
            return res;
        }
    }
}
