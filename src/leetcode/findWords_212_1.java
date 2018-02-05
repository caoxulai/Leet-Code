/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findWords_212_1 {
    // 94.09%
    // Using Trie structure, dfs
    class Solution {
        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            String word = null;
        }
        
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            if(board == null || board.length==0 || board[0].length==0)  return res;
            
            TrieNode root = buildTrie(words);
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    searchWord(res, board, i, j, root);
                }
            }
            return res;
        }
        
        private void searchWord(List<String> res, char[][] board, int i, int j, TrieNode node){
            char c = board[i][j];
            if(c == '#' || node.next[c-'a'] == null) return;
            node = node.next[c-'a'];
            if(node.word != null){
                res.add(node.word);
                node.word = null;
            }
            int row = board.length;
            int col = board[0].length;
            board[i][j] = '#';
            if(i > 0)         searchWord(res, board, i-1, j, node);
            if(i < row-1)     searchWord(res, board, i+1, j, node);
            if(j > 0)         searchWord(res, board, i, j-1, node);
            if(j < col-1)     searchWord(res, board, i, j+1, node);
            board[i][j] = c;
        }
        
        private TrieNode buildTrie(String[] words){
            TrieNode root = new TrieNode();
            for(String word: words){
                TrieNode cur = root;
                for(char c: word.toCharArray()){
                    if(cur.next[c-'a'] == null)     cur.next[c-'a'] = new TrieNode();
                    cur = cur.next[c-'a'];
                }
                cur.word = word;
            }
            return root;
        }
    }
}
