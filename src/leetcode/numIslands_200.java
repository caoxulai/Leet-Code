/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class numIslands_200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int res = 0;
            int row = grid.length;
            if(row==0)  return res;
            int col = grid[0].length;
            
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            
            for(int i=0; i<row; i++){
                for(int j=0; j<col; j++){
                    if(grid[i][j] == '1'){
                        res++;
                        grid[i][j] = '0';
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        while(!queue.isEmpty()){
                            int[] land = queue.poll();
                            for(int k=0; k<4; k++){
                                int r = land[0] + dr[k];
                                int c = land[1] + dc[k];
                                if(r>=0 && r<row && c>=0 && c<col && grid[r][c]=='1'){
                                    grid[r][c]='0';
                                    queue.offer(new int[]{r, c});
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
