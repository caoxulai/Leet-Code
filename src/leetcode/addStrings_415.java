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
public class addStrings_415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length();
            int len2 = num2.length();
            int i=len1-1, j=len2-1;
            int c = 0;
            StringBuilder sb = new StringBuilder();
            while(i>=0 || j>=0){
                int n1 = i<0? 0: num1.charAt(i--) - '0';
                int n2 = j<0? 0: num2.charAt(j--) - '0';
                c += n1 + n2;
                sb.append(c%10);
                c /= 10;
            }
            if(c!=0)    sb.append(c);
            return sb.reverse().toString();
        }
    }
}
