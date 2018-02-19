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
public class intToRoman_012 {
    class Solution {
        public String intToRoman(int num) {
            String[] M = new String[]{"M", "MM", "MMM"};
            String[] C = new String[]{"C", "CC", "CCC", "CL", "D", "DC", "DCC", "DCCC", "CM"};
            String[] X = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] I = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            
            return M[num/1000-1] + C[num%1000/100-1] + X[num%100/10-1] + I[num%10-1];
        }
    }
}

