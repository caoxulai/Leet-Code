/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class pathSum_113 {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            backTrack(res, new ArrayList<>(), root, sum);
            return res;
        }
        
        private void backTrack(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum){
            if(node == null)    return;
            if(node.left == null && node.right == null){
                if(sum == node.val){
                    list.add(node.val);
                    res.add(new ArrayList<>(list));
                    list.remove(list.size()-1);
                }
                return;
            }
            list.add(node.val);
            backTrack(res, list, node.left, sum-node.val);
            backTrack(res, list, node.right, sum-node.val);
            list.remove(list.size()-1);
        }
    }
}
