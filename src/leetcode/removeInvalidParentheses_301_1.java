/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Bryce
 */
public class removeInvalidParentheses_301_1 {
    // 11.67%
    // BFS, intuitive but not as fast as dfs for this problem
    class Solution {
        public List<String> removeInvalidParentheses(String s){
            List<String> res = new ArrayList<>();
            if(s == null)   return res;
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(s);
            boolean found = false;
            while(!queue.isEmpty()){
                String t = queue.poll();
                if(isValid(t)){
                    res.add(t);
                    found = true;
                }
                if(found)   continue;
                
                for(int i=0; i<t.length(); i++){
                    if(t.charAt(i) == '(' || t.charAt(i) == ')'){
                        String next = t.substring(0, i) + t.substring(i+1);
                        if(!visited.contains(next)){
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
            return res;
        }
        
        private boolean isValid(String s){
            int count = 0;
            for(char c: s.toCharArray()){
                if(c == '(')    count++;
                if(c == ')' && count-- == 0)    return false;
            }
            return count==0;
        }
    }
}
