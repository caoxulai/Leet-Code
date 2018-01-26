/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class findMode_501 {
    class Solution {
        int currCount = 1;
        int maxCount = 0;
        Integer pre = null;
        List<Integer> list = new ArrayList<>();
        
        public int[] findMode(TreeNode root) {
            inOrder(root);
            int[] res = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                res[i] = list.get(i);
            }
            return res;
        }
        
        private void inOrder(TreeNode node){
            if(node == null)    return;
            
            inOrder(node.left);
            
            if(pre != null){
                if(pre == node.val){
                    currCount++;
                }
                else{
                    currCount = 1;
                }
            }
            if(currCount == maxCount){
                list.add(node.val);
            }
            else if(currCount > maxCount){
                maxCount = currCount;
                list.clear();
                list.add(node.val);
            }
            pre = node.val;
            
            inOrder(node.right);
        }
    }
}
