package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class reverseVowels_345 {
    class Solution {
        Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));

        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int i=0, j=s.length()-1;
            while (i <  j) {
                while(i < j && !isVowel(chars[i]))  i++;
                while(i < j && !isVowel(chars[j]))  j--;
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
            return new String(chars);
        }

        private boolean isVowel(char c) {
            return vowels.contains(c);
        }
    }
}
