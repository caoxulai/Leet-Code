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
public class removeInvalidParentheses_301 {
    // 67.04 %
    // traverse the string from 2 directions to make sure it's valid
    // DFS
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> res = new ArrayList<>();
            remove(res, s, 0, 0, new char[]{'(', ')'});
            return res;
        }
        
        private void remove(List<String> res, String s, int toCheck, int toRemove, char[] par){
            for(int i=toCheck, count=0; i<s.length(); i++){
                if(s.charAt(i) == par[0])   count++;
                else if(s.charAt(i) == par[1])  count--;
                if(count >= 0)  continue;
                for(int j=toRemove; j<=i; j++){
                    if(s.charAt(j) == par[1] && (j == toRemove || s.charAt(j) != s.charAt(j-1)))
                        // intuitively i & j should increse by 1
                        // but as the prefix has been removed 1 character, just passing i & j is fine.
                        remove(res, s.substring(0, j) + s.substring(j+1), i, j, par);
                }
                // no need to continue this method, s is invalid
                return;
            }
            
            // reverse the string
            s = new StringBuilder(s).reverse().toString();
            if(par[0] == '(')   // finished left to right
                remove(res, s, 0, 0, new char[]{')', '('});
            else                // finished right to left
                res.add(s);
        }
    }
}
