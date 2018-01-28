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
public class myAtoi_008 {
    class Solution {
        public int myAtoi(String str) {
            if (str.isEmpty()) return 0;
            int sign = 1, base = 0, i = 0;
            while (str.charAt(i) == ' ')
                i++;
            if (str.charAt(i) == '-' || str.charAt(i) == '+')
                sign = str.charAt(i++) == '-' ? -1 : 1;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                base = 10 * base + (str.charAt(i++) - '0');
            }
            return base * sign;
        }
    }
}
