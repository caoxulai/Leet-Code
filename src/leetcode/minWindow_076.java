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
public class minWindow_076 {
    class Solution {
        public String minWindow(String s, String t) {
            String res = new String();
            int head=0, min = Integer.MAX_VALUE;
            if (s == null || s.length() == 0 || t == null || t.length() == 0) return res;
            
            int[] map = new int[128];
            for(char c : t.toCharArray()){
                map[c]++;
            }
            int cnt  = t.length();
            int start=0, end=0;
            while(end<s.length()){
                char c = s.charAt(end++);
                if(map[c]-->0)    cnt--;
                while(cnt==0){
                    int len = end-start;
                    if(len<min){
                        min = len;
                        head = start;
                    }
                    char cs = s.charAt(start++);
                    if(map[cs]++ == 0)  cnt++;
                }
            }
            return min == Integer.MAX_VALUE ? "" : s.substring(head, head+min);
        }
    }
}
