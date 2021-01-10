/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findFrequentTreeSum_508 {
    class Solution {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int maxCount = 0;
        
        public int[] findFrequentTreeSum(TreeNode root) {
            postOrderSum(root);
            
            int[] res = new int[list.size()];
            for(int i=0; i<res.length; i++){
                res[i] = list.get(i);
            }
            return res;
        }
        
        private int postOrderSum(TreeNode node){
            if(node==null)  return 0;
            int left = postOrderSum(node.left);
            int right = postOrderSum(node.right);
            int sum = left + right + node.val;
            
            int cnt = count.getOrDefault(sum, 0) + 1;
            count.put(sum, cnt);
            if(cnt == maxCount){
                list.add(sum);
            }
            else if(cnt > maxCount){
                maxCount = cnt;
                list.clear();
                list.add(sum);
            }
            return sum;
        }
    }
}
