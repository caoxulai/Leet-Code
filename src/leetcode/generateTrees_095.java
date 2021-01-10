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
public class generateTrees_095 {
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n==0)    return new ArrayList<>();
            return generateTrees(1, n);
        }
        
        public List<TreeNode> generateTrees(int i, int j) {
            List<TreeNode> list = new ArrayList<>();
            if(i > j){
                list.add(null);
            }else if(i == j){
                list.add(new TreeNode(i));
            }else{
                for(int root=i; root<=j; root++){
                    List<TreeNode> left = generateTrees(i, root-1);
                    List<TreeNode> right = generateTrees(root+1, j);
                    for(TreeNode l: left){
                        for(TreeNode r: right){
                            TreeNode node = new TreeNode(root);
                            node.left = l;
                            node.right = r;
                            list.add(node);
                        }
                    }
                }
            }
            return list;
        }
    }
}
