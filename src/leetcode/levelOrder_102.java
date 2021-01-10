/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class levelOrder_102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null)    return res;
            
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for(int i=0; i<size; i++){
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null)   queue.offer(node.left);
                    if(node.right != null)   queue.offer(node.right);
                }
                res.add(list);
            }
            return res;
        }
    }
}
