/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class courseScheduleFindOrder_210 {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            boolean[][] prereq = new boolean[numCourses][numCourses];
            int[] inDegree = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                int next = prerequisite[0];
                int pre = prerequisite[1];
                if(!prereq[pre][next]){
                    inDegree[next]++;
                    prereq[pre][next] = true;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int j=0; j<numCourses; j++){
                if(inDegree[j] == 0)    queue.offer(j);
            }
            
            int[] res = new int[numCourses];
            int index = 0;
            while(!queue.isEmpty()){
                int pre = queue.poll();
                res[index++] = pre;
                for(int i=0; i<numCourses; i++){
                    if(prereq[pre][i]){
                        if(--inDegree[i] == 0)
                            queue.offer(i);
                    }
                }
            }
            return index == numCourses? res: new int[0];
        }
    }
}
