/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author I852047
 */
public class kthSmallest_378 {
    class Solution {
        // 44.46%
        // using the properties for the 2D sorted matrix and in a row/col, next bigger element will be the adjacent node
        public int kthSmallest(int[][] matrix, int k) {
            int row = matrix.length;
            int col = matrix[0].length;
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
                // lambda expression would worsen the performance
                // Overriding compare method is faster
                @Override
                public int compare(int[] a, int[] b){
                    return a[0] - b[0];
                }
            });
            
            for(int j=0; j<col; j++)    queue.offer(new int[]{matrix[0][j], 0, j});
            
            for(int x=1; x<k; x++){
                int[] e = queue.poll();
                if(e[1] == row - 1) continue;
                queue.offer(new int[]{matrix[e[1]+1][e[2]], e[1]+1, e[2]});
            }
            
            int[] top = queue.poll();
            return top[0];
        }
    }
}
