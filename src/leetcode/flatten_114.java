/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Bryce
 */
public class flatten_114 {
    class Solution {
        public void flatten(TreeNode root) {
            if(root == null)  return;
            Stack<TreeNode> stack = new Stack<>();
            Queue<TreeNode> queue = new LinkedList<>();
            while(root!=null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    queue.offer(root);
                    root = root.left;
                }
                root = stack.pop().right;
            }
            
            root = queue.poll();
            root.left = null;
            TreeNode pre = root;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                node.left = null;
                pre.right = node;
                pre = node;
            }
        }
    }
}
