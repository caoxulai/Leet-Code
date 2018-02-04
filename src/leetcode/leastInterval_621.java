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
public class leastInterval_621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            if(tasks==null || tasks.length==0) return 0;
            
            int[] count = new int[128];
            for(char c : tasks){
                count[c]++;
            }
            
            int max = 0;
            
            for(int i=0; i<128; i++){
                max = Math.max(max, count[i]);
            }
            
            int idle = (max-1) * (n+1);
            for(int i=0; i<128; i++){
                if(count[i]>0)
                    idle -= Math.min(max-1, count[i]);
            }
            return idle>0 ? tasks.length + idle: tasks.length;
        }
    }
}
