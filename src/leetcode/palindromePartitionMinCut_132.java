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
public class palindromePartitionMinCut_132 {
    class Solution {
        public int minCut(String s) {
            int len = s.length();
            if(len<2)   return 0;
            int[] cut = new int[len+1];
            for(int x=0; x<=len; x++){
                cut[x] = x-1;
            }
            
            for(int i=0; i<len; i++){
                for(int j=0; i-j>=0 && i+j<len && s.charAt(i-j)==s.charAt(i+j); j++)
                    cut[i+j+1] = Math.min(cut[i+j+1], cut[i-j] + 1);
                for(int j=0; i-j>=0 && i+j+1<len && s.charAt(i-j)==s.charAt(i+1+j); j++)
                    cut[i+j+2] = Math.min(cut[i+j+2], cut[i-j] + 1);
            }
            return cut[len];
        }
    }
}