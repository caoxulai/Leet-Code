/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findLadders_126 {
    HashMap<String, List<String>> map = new HashMap<>();
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        if(wordList.isEmpty())  return res;
        HashSet<String> set = new HashSet<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        set.add(beginWord);
        unvisited.remove(beginWord);
        boolean found = false;
        while(!set.isEmpty()){
            if(found)   break;
            HashSet<String> temp = new HashSet<>();
            for(String s: set){
                for(int i=0; i<s.length(); i++){
                    StringBuilder sb = new StringBuilder(s);
                    for(char c = 'a'; c<='z'; c++){
                        sb.setCharAt(i, c);
                        String newWord = sb.toString();
                        if(unvisited.contains(newWord)){
                            if(newWord.equals(endWord))
                                found=true;
                            temp.add(newWord);
                            
                            //building the neighbour map
                            if(map.containsKey(newWord))
                                map.get(newWord).add(s);          // to be verified
                            else{
                                List<String> neighbours = new ArrayList<>();
                                neighbours.add(s);
                                map.put(newWord, neighbours);
                            }
                        }
                    }
                }
            }
            unvisited.removeAll(temp);
            set = temp;
        }
        
        backTrace(beginWord, endWord);
        return res;
    }
    
    private void backTrace(String beginWord, String endWord){
        if(beginWord.equals(endWord)){
            list.add(0, beginWord);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        if(map.containsKey(endWord)){
            list.add(0, endWord);
            for(String pre: map.get(endWord)){
                backTrace(beginWord, pre);
            }
            list.remove(0);
        }
    }
}
