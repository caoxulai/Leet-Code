/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

/**
 *
 * @author I852047
 */
public class palindromePartitionMinCut_132_1 {
    class Solution {
        public int minCut(String s) {
            int len = s.length();
            if(len<2)   return 0;
            int[] cut = new int[len+1];
            boolean[][] pal = new boolean[len][len];
            for(int j=0; j<len; j++){
                cut[j] = j;
                for(int i=0; i<=j; i++){
                    if(s.charAt(i) == s.charAt(j) &&(i+1>=j-1 || pal[i+1][j-1])){
                        pal[i][j] = true;
                        
                        cut[j] = i==0? 0: Math.min(cut[j], cut[i-1] + 1);
                    }
                }
            }
            
            return cut[len-1];
        }
    }
}
