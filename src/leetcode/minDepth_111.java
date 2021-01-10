/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Bryce
 */
public class minDepth_111 {
    class Solution {
        public int minDepth(TreeNode root) {
            int res = 0;
            if(root == null)    return res;
            
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                res++;
                int size = queue.size();
                for(int i=0; i<size; i++){
                    TreeNode node = queue.poll();
                    if(node.left == null && node.right == null) return res;
                    if(node.left != null)   queue.offer(node.left);
                    if(node.right != null)   queue.offer(node.right);
                }
            }
            return res;
        }
    }
}
