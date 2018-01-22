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
public class updateBoard_529 {
    class Solution {
        int row;
        int col;
        
        public char[][] updateBoard(char[][] board, int[] click) {
            row = board.length;
            if(row==0)  return board;
            col = board[0].length;
            
            Queue<int []> queue = new LinkedList<>();
            queue.offer(click);
            int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
            int[] dc = {1, 0, -1, 1, -1, 1, 0, -1};
            
            while(!queue.isEmpty()){
                int[] c = queue.poll();
                if(board[c[0]][c[1]] == 'M'){
                    board[c[0]][c[1]] = 'X';
                    break;
                }
                int mines = numsOfMine(board, c);
                if(mines==0){
                    board[c[0]][c[1]] = 'B';
                    for(int i=0; i<8; i++){
                        int nr = c[0] + dr[i];
                        int nc = c[1] + dc[i];
                        if(nr<0 || nr>= row || nc<0 || nc>=col) continue;
                        if (board[nr][nc] == 'E') {
                            // critical check,
                            queue.offer(new int[]{nr, nc});
                            // critical assignment to avoid one node to be added into queue again
                            board[nr][nc] = 'B';
                        }
                    }
                }
                else{
                    board[c[0]][c[1]] = (char)(mines + '0');
                }
            }
            return board;
        }
        
        private int numsOfMine(char[][] board, int[] click){
            int count=0;
            int[] dr = {1, 1, 1, 0, 0, -1, -1, -1};
            int[] dc = {1, 0, -1, 1, -1, 1, 0, -1};
            
            for(int i=0; i<8; i++){
                int nr = click[0] + dr[i];
                int nc = click[1] + dc[i];
                if(nr<0 || nr>= row || nc<0 || nc>=col) continue;
                if(board[nr][nc] == 'M' || board[nr][nc] == 'X')
                    count++;
            }
            return count;
        }
    }
    
}
