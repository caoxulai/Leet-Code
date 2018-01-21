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
public class firstUniqChar_387 {
    public int firstUniqChar(String s) {
        int[] count = new int[128];
        for(char c: s.toCharArray()){
            count[c]++;
        }
        for(int i=0; i< s.length(); i++){
            if(count[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
