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
public class minDistance_072 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] min = new int[len1 + 1][len2 + 1];
            for(int i=0; i<=len1; i++)  min[i][0] = i;
            for(int j=0; j<=len2; j++)  min[0][j] = j;
            
            for(int i=1; i<=len1; i++){
                for(int j=1; j<=len2; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        min[i][j] = min[i-1][j-1];
                    }else{
                        min[i][j] = 1 + Math.min(min[i-1][j-1], Math.min(min[i][j-1], min[i-1][j]));
                    }
                }
            }
            return min[len1][len2];
        }
    }
}
