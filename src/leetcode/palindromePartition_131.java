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
public class palindromePartition_131 {
    class Solution {
        
        boolean[][] isPalindrome;
        boolean[][] checked;
        
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            int len = s.length();
            isPalindrome = new boolean[len][len+1];
            checked = new boolean[len][len+1];
            backTrack(res, new ArrayList<>(), s, 0);
            return res;
        }
        
        private void backTrack(List<List<String>> res, List<String> list, String s, int start){
            if(start == s.length()){
                res.add(new ArrayList<>(list));
            }
            for(int end=start+1; end<=s.length(); end++){
                if(isPalindrome[start][end] || !checked[start][end] && isPalindrome(s, start, end-1)){
                    isPalindrome[start][end] = true;
                    list.add(s.substring(start, end));
                    backTrack(res, list, s, end);
                    list.remove(list.size() - 1);
                }
                checked[start][end] = true;
            }
            
        }
        
        public boolean isPalindrome(String s, int lo, int hi){
            while(lo < hi)
                if(s.charAt(lo++) != s.charAt(hi--)) return false;
            return true;
        }
    }
}
