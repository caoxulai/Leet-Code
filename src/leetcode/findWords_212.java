/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Bryce
 */
public class findWords_212 {
    // Backtracking
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            Set<String> res = new HashSet<>();
            for(String word: words){
                if(exist(board, word))
                    res.add(word);
            }
            return new ArrayList<String>(res);
        }
        
        private boolean exist(char[][] board, String word) {
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
