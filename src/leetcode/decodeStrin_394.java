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
public class decodeStrin_394 {
    class Solution {
        public String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c>='0' && c<='9'){
                    int index = s.indexOf(']');
                    String str = decodeString(s.substring(i+2, index));
                    for(int j=0; j<c-'0'; j++){
                        sb.append(str);
                    }
                    i = index;
                }
                else{
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
