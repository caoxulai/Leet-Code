/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

import java.util.Stack;

/**
 *
 * @author Bryce
 */
public class SerializeAndDeserializeBinaryTree_297_1 {
    // DFS
    public class dfsCodec {
        String nullSymbol = "X";
        String spliter = ",";
        
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)  return new String();
            Stack<TreeNode> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                while(node != null){
                    sb.append(node.val);
                    sb.append(spliter);
                    stack.push(node.right);
                    node = node.left;
                }
                sb.append(nullSymbol);
                sb.append(spliter);
            }
            return sb.toString();
        }
        
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length() == 0)   return null;
            String[] values = data.split(spliter);
            TreeNode root = new TreeNode(0);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            for(int i=0; i<values.length; i++){
                TreeNode node = stack.pop();
                while(i<values.length && !values[i].equals(nullSymbol)){
                    node = new TreeNode(Integer.valueOf(values[i++]));
                    stack.push(node.right);
                    node = node.left;
                }
            }
            return root;
        }
    }
    
}
