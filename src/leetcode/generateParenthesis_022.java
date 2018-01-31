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
public class generateParenthesis_022 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            backTrack(res, new StringBuilder(), n, n);
            return res;
        }
        
        private void backTrack(List<String> res, StringBuilder sb, int left, int right){
            if(left==0 && right==0){
                res.add(sb.toString());
            }
            else{
                if(left>0){
                    sb.append('(');
                    backTrack(res, sb, left-1, right);
                    sb.setLength(sb.length() - 1);
                }
                if(right>left){
                    sb.append(')');
                    backTrack(res, sb, left, right-1);
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
}
