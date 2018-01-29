/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findLadders_127 {
    public int findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty())  return 0;
        int res = 1;
        HashSet<String> next = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        next.add(beginWord);
        unvisited.remove(beginWord);
        while(!next.isEmpty()){
            res++;
            HashSet<String> temp = new HashSet<>();
            for(String s: next){
                for(int i=0; i<s.length(); i++){
                    // find all possible adjacent words to check if it's in the wordList
                    StringBuilder sb = new StringBuilder(s);
                    for(char c = 'a'; c<='z'; c++){
                        sb.setCharAt(i, c);
                        String newWord = sb.toString();
                        if(unvisited.contains(newWord)){
                            if(newWord.equals(endWord)) return res;
                            temp.add(newWord);
                            unvisited.remove(newWord);
                        }
                    }
                }
            }
            next = temp;
        }
        return 0;
    }
}
