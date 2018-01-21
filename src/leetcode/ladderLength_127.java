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
public class ladderLength_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty())  return 0;
        int res = 1;
        HashSet<String> set = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        set.add(beginWord);
        unvisited.remove(beginWord);
        while(!set.isEmpty()){
            res++;
            HashSet<String> temp = new HashSet<>();
            for(String s: set){
                for(int i=0; i<s.length(); i++){
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
            set = temp;
        }
        return 0;
    }
}
