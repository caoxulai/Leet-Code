package leetcode;

import leetcode.util.TreeNode;

public class constructMaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int s, int e) {
        if(s >= e)  return null;
        int maxIndex = findMax(nums, s, e);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructMaximumBinaryTree(nums, s, maxIndex);
        node.right = constructMaximumBinaryTree(nums, maxIndex + 1, e);
        return node;
    }

    private int findMax(int[] nums, int s, int e) {
        int max = Integer.MIN_VALUE, index = -1;
        for(int i=s; i<e; i++) {
            if(max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
