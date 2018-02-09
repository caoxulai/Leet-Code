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
public class courseScheduleCanFinish_207 {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            
            int count = 0;
            while(!queue.isEmpty()){
                int pre = queue.poll();
                count++;
                for(int i=0; i<numCourses; i++){
                    if(prereq[pre][i]){
                        if(--inDegree[i] == 0)
                            queue.offer(i);
                    }
                }
            }
            return count == numCourses;
        }
    }
}
