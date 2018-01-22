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
public class SerializeAndDeserializeBST_449 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {
        String nullSymbol = "X";
        String spliter = ",";
        
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)  return new String();
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node != null){
                    sb.append(node.val);
                    sb.append(spliter);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                else{
                    sb.append(nullSymbol);
                    sb.append(spliter);
                }
                
            }
            return sb.toString();
        }
        
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length() == 0)   return null;
            String[] values = data.split(spliter);
            TreeNode root = new TreeNode(Integer.valueOf(values[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            for(int i=1; i<values.length; i++){
                TreeNode node = queue.poll();
                if(!values[i].equals(nullSymbol)){
                    node.left = new TreeNode(Integer.valueOf(values[i]));
                    queue.offer(node.left);
                }
                if(!values[++i].equals(nullSymbol)){
                    node.right = new TreeNode(Integer.valueOf(values[i]));
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }
    
    
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
