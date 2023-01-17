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
public class lengthOfLongestSubstring_003_2 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res=0;
            if (s == null || s.length() == 0) return res;

            int[] count = new int[128];
            boolean duplicated = false;
            for(int start=0, end=0; end<s.length(); end++){
                char c = s.charAt(end);
                if(count[c]++ == 1) duplicated = true;
                while(duplicated){
                    char cs = s.charAt(start++);
                    if(--count[cs] == 1)    duplicated = false;
                }
                res = Math.max(res, end - start +1);
            }
            return res;
        }
    }
}
