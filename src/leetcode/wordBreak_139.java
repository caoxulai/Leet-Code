/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.List;

/**
 *
 * @author Bryce
 */
public class wordBreak_139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s==null || s.length()==0)    return true;
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;
            int last = 0;
            int L = longestLength(wordDict);
            for(int j=1; j<=s.length(); j++){
                if(j > last + L)    break;
                for(int i=Math.max(0, j-L); i<j; i++){
                    String t = s.substring(i, j);
                    if(dp[i] && wordDict.contains(t)){
                        dp[j] = true;
                        last = j;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
        
        private int longestLength(List<String> wordDict){
            int len = 0;
            for(String s: wordDict){
                len = Math.max(len, s.length());
            }
            return len;
        }
    }
    
}
