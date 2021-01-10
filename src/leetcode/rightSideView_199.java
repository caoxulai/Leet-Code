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
public class rightSideView_199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null)    return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                int last = 0;
                for(int i=0; i<size; i++){
                    TreeNode node = queue.poll();
                    last = node.val;
                    if(node.left != null)   queue.offer(node.left);
                    if(node.right != null)   queue.offer(node.right);
                }
                res.add(last);
            }
            return res;
        }
    }
}
