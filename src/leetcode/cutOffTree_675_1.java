/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class cutOffTree_675_1 {
    class Solution {
        public int cutOffTree(List<List<Integer>> forest) {
            int res = 0;
            PriorityQueue<int[]> trees = new PriorityQueue<>((a, b)->Integer.compare(a[0], b[0]));
            for(int i=0; i<forest.size(); i++){
                for(int j=0; j<forest.get(0).size(); j++){
                    int height = forest.get(i).get(j);
                    if(height > 1){
                        trees.add(new int[]{height, i, j});
                    }
                }
            }
            
            int sr=0, sc=0, tr=0, tc=0;
            while(!trees.isEmpty()){
                int[] tree = trees.poll();
                tr = tree[1]; tc = tree[2];
                int dist = minStep(forest, sr, sc, tr, tc);
                if(dist == -1)  return -1;
                res += dist;
                sr = tr; sc = tc;
            }
            return res;
        }
        
        private int minStep(List<List<Integer>>forest, int sr, int sc, int tr, int tc){
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            int R = forest.size();
            int C = forest.get(0).size();
            boolean[][] visited = new boolean[R][C];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, sr, sc});
            while(!queue.isEmpty()){
                int[] tree = queue.poll();
                if(tree[1]==tr && tree[2]==tc)    return tree[0];
                int step = tree[0] + 1;
                for(int i=0; i<4; i++){
                    int nr = tree[1] + dr[i];
                    int nc = tree[2] + dc[i];
                    if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc] && forest.get(nr).get(nc)!=0){
                        queue.offer(new int[]{step, nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            return -1;
        }
    }
}
