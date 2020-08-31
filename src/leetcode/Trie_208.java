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
public class Trie_208 {
    public static void main(String [] args){
        Trie obj = new Trie();
        obj.insert("app");
        obj.insert("apple");
        obj.insert("beer");
        obj.insert("add");
        obj.insert("jam");
        obj.insert("rental");
        boolean param_3 = obj.startsWith("jan");
        System.out.println(param_3);
        
    }
    
    static class Trie {
        Trie[] next;
        String word;
        
        /** Initialize your data structure here. */
        public Trie() {
            next = new Trie[26];
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie cur = this;
            for(char c: word.toCharArray()){
                int index = c-'a';
                if(cur.next[index] == null) cur.next[index] = new Trie();
                cur = cur.next[index];
            }
            cur.word = word;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie cur = this;
            for(char c: word.toCharArray()){
                if(cur.next[c-'a'] == null)     return false;
                cur = cur.next[c-'a'];
            }
            return word.equals(cur.word);
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie cur = this;
            for(char c: prefix.toCharArray()){
                int index = c-'a';
                if(cur.next[index] == null)     return false;
                cur = cur.next[index];
            }
            return true;
        }
    }
}
