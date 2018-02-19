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
public class romanToInt_013 {
    // 64.34%
    class Solution {
        public int romanToInt(String s){
            int res = 0;
            for(int i=s.length()-1; i>=0; i--){
                char c = s.charAt(i);
                switch(c){
                    case 'I':
                        res += res>=5 ? -1: 1;
                        break;
                    case 'V':
                        res += 5;
                        break;
                    case 'X':
                        res += res>=50 ? -10: 10;
                        break;
                    case 'L':
                        res += 50;
                        break;
                    case 'C':
                        res += res>=500 ? -100: 100;
                        break;
                    case 'D':
                        res += 500;
                        break;
                    case 'M':
                        res += 1000;
                        break;
                }
            }
            return res;
        }
    }
}
