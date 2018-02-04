/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author Bryce
 */
public class existWordSearch_079 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            if(word == null || word.equals(""))     return true;
            if(board == null || board.length==0 || board[0].length==0)  return false;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(exist(board, word, i, j, new boolean[board.length][board[0].length]))
                        return true;
                }
            }
            return false;
        }
        
        private boolean exist(char[][] board, String word, int i, int j, boolean[][] visited){
            if(word.equals(""))    return true;
            int row = board.length;
            int col = board[0].length;
            if(i<0 || i>=row || j<0 || j>=col || visited[i][j] || board[i][j] != word.charAt(0))
                return false;
            
            int[] dr = new int[]{1, -1, 0, 0};
            int[] dc = new int[]{0, 0, 1, -1};
            for(int x=0; x<4; x++){
                int nr = i + dr[x];
                int nc = j + dc[x];
                visited[i][j] = true;
                if(exist(board, word.substring(1), nr, nc, visited))
                    return true;
                visited[i][j] = false;
            }
            return false;
        }
    }
}
