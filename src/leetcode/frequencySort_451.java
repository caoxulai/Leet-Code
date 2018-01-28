/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bryce
 */
public class frequencySort_451 {
    public static void main(String [] args)
    {
        System.out.println("eeeeee");
        System.out.println(frequencySort("eeeeee"));
    }    
    
    public static String frequencySort(String s) {
        HashMap<Character, Integer> keyToCount = new HashMap<>();
        HashMap<Integer, Set<Character>> countToKeys = new HashMap<>();
        
        for(char key: s.toCharArray()){
            int count = keyToCount.getOrDefault(key, 0);
            keyToCount.put(key, count+1);
            if(countToKeys.containsKey(count+1))
                countToKeys.get(count+1).add(key);
            else{
                Set<Character> set = new HashSet<>();
                set.add(key);
                countToKeys.put(count+1, set);
            }
            if(count > 0){
                countToKeys.get(count).remove(key);
                if(countToKeys.get(count).size() == 0)
                    countToKeys.remove(count);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=s.length(); i>=0; i--){
            if(countToKeys.containsKey(i)){
                for(char c: countToKeys.get(i))
                    for(int j=0; j<i; j++){
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }
}
