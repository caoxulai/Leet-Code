/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.PriorityQueue;

/**
 *
 * @author Bryce
 */
public class trapRainWater_2D_407 {
    
    public static void main(String [] args)
    {
        LFUCache_460 obj = new LFUCache_460(2);
        int heightMap[][] = {
            {1,4,3,1,3,2},
            {3,2,1,3,2,4},
            {2,3,3,2,3,1}};
        int n = trapRainWater(heightMap);
        System.out.println(n);
    }
    
    
    public static int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length<3 || heightMap[0].length<3)  return 0;
        int water = 0;
        int row = heightMap.length;
        int col = heightMap[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(100, (a, b)->Integer.compare(a[0],b[0]));
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            queue.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][0] = true;
            queue.offer(new int[]{heightMap[i][col-1], i, col-1});
            visited[i][col-1] = true;
        }
        
        for(int j=1; j<col-1; j++){
            queue.offer(new int[]{heightMap[0][j], 0, j});
            visited[0][j] = true;
            queue.offer(new int[]{heightMap[row-1][j], row-1, j});
            visited[row-1][j] = true;
        }
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int i=0; i<4; i++){
                int r = cell[1] + dr[i];
                int c = cell[2] + dc[i];
                if(r>0 && r<row-1 && c>0 && c<col-1 && !visited[r][c]){
                    visited[r][c] = true;
                    water += Math.max(0, cell[0] - heightMap[r][c]);
                    int height = Math.max(cell[0], heightMap[r][c]);
                    queue.offer(new int[]{height, r, c});
                }
            }
        }
        return water;
    }
}
