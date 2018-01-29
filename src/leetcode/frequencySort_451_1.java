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
public class frequencySort_451_1 {
    class Solution {
        public String frequencySort(String s) {
            int[] count = new int[128];
            
            for(char c: s.toCharArray()){
                count[c]++;
            }
            
            StringBuilder[] freq = new StringBuilder[s.length()+1];
            for(int i=0; i<128; i++){
                if(count[i]>0){
                    if(freq[count[i]] == null)  freq[count[i]] = new StringBuilder();
                    freq[count[i]].append((char)i);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=s.length(); i>=0; i--){
                if(freq[i] != null){
                    for(char c: freq[i].toString().toCharArray())
                        for(int j=0; j<i; j++){
                            sb.append(c);
                        }
                }
            }
            return sb.toString();
        }
    }
}
