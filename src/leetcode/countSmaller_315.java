/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bryce
 */
public class countSmaller_315 {
    // 72.85%
    class Solution {
        class Node{
            int val, count, leftSum;
            Node left, right;
            public Node(int v){
                val = v;
                count = 1;
                leftSum = 0;
            }
        }
        public List<Integer> countSmaller(int[] nums) {
            int len = nums.length;
            Integer[] count = new Integer[len];
            Node root = null;
            for(int i=len-1; i>=0; i--){
                root = insert(root, count, nums[i], i, 0);
            }
            return Arrays.asList(count);
        }
        
        private Node insert(Node root, Integer[] count, int num, int index, int smaller){
            if(root == null){
                root = new Node(num);
                count[index] = smaller;
                return root;
            }else if(root.val == num){
                count[index] = smaller + root.leftSum;
                root.count++;
                return root;
            }else if(num < root.val){
                root.leftSum++;
                root.left = insert(root.left, count, num, index, smaller);
            }else{
                root.right = insert(root.right, count, num, index, smaller + root.count + root.leftSum);
            }
            return root;
        }
    }
}
