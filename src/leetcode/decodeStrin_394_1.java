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
public class decodeStrin_394_1 {
    // 73.54%
    // revised version, the key is I didn't understand the stop trigger fully before
    class Solution {
        public String decodeString(String s) {
            return getStringBlock(s);
        }
        
        
        int i=0;        
        public String getStringBlock(String s) {
            StringBuilder sb = new StringBuilder();
            while(i<s.length() && s.charAt(i) != ']'){
                // i<s.length() is for the initial call of getStringBlock method
                // s.charAt(i) != ']' is for all downstream calls of getStringBlock method,
                //      all the downstream calls must be triggered by a '[' ']' pair
                if(s.charAt(i)<'0' || s.charAt(i)>'9')  sb.append(s.charAt(i++));
                else{
                    int n = 0;
                    while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                        n = n*10 + s.charAt(i)-'0';
                        i++;
                    }
                    
                    i++;    // i is now pointing to '[', skip it
                    String next = getStringBlock(s);
                    for(int x=0; x<n; x++){
                        sb.append(next);
                    }
                    i++;    // i must be pointing to ']' if s if valid, skip it
                }
            }
            return sb.toString();
        }
    }
}
