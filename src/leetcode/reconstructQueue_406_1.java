/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class reconstructQueue_406_1 {
    // 81.81%
    // override compare method instead of lambda expression
    // use List.toArray() method
    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //pick up the tallest guy first
            //when insert the next tall guy, just need to insert him into kth position
            //repeat until all people are inserted into list
            Arrays.sort(people, new Comparator<int[]>(){
                // lambda expression would worsen the performance
                // Overriding compare method is faster
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] != b[0])    return b[0] - a[0];
                    else return a[1] - b[1];
                }
            });
            List<int[]> res = new LinkedList<>();
            for(int[] cur : people){
                res.add(cur[1],cur);
            }
            // use List.toArray() method will improve performance
            return res.toArray(new int[people.length][]);
        }
        
    }
}
