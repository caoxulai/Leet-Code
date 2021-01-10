/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import leetcode.util.TreeNode;

/**
 *
 * @author I852047
 */
public class sortedArrayToBST_108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildTree(nums, 0, nums.length-1);
        }
        
        private TreeNode buildTree(int[] nums, int lo, int hi){
            if(lo > hi)   return null;
            if(lo == hi)    return new TreeNode(nums[lo]);
            int mid = lo + (hi-lo)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildTree(nums, lo, mid-1);
            node.right = buildTree(nums, mid+1, hi);
            return node;
        }
    }
}
