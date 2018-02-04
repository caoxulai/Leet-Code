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
public class existWordSearch_079_1 {
    // set board[i][j] to special character to save the space and access time for 2d boolean array visited[][]
    class Solution {
        public boolean exist(char[][] board, String word) {
            if(word == null || word.equals(""))     return true;
            if(board == null || board.length==0 || board[0].length==0)  return false;
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(exist(board, word, 0, i, j))
                        return true;
                }
            }
            return false;
        }
        
        private boolean exist(char[][] board, String word, int index, int i, int j){
            if(index == word.length())    return true;
            int row = board.length;
            int col = board[0].length;
            if(i<0 || i>=row || j<0 || j>=col || board[i][j] != word.charAt(index))
                return false;
            
            board[i][j]='*';
            boolean result =    exist(board, word, index+1, i+1, j) ||
                                exist(board, word, index+1, i-1, j) ||
                                exist(board, word, index+1, i, j+1) ||
                                exist(board, word, index+1, i, j-1);
            board[i][j]=word.charAt(index);
            
            return result;
        }
    }
}
