package leetcode;

import leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class widthOfBinaryTree_662 {

    public static void main(String [] args)    {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node1;
        root.right = node2;


        node1.left = node3;
        node1.right = node4;


        node2.left = null;
        node2.right = node8;



        System.out.println(widthOfBinaryTree(root));
    }
    private static int numOfNulls = 0;

    public static int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        List<TreeNode> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        while(currentLevel.size() > 0) {
            max = Math.max(max, currentLevel.size());
            List<TreeNode> nextLevel = new LinkedList<>();
            for(TreeNode node : currentLevel) {
                if(node == null)
                    numOfNulls += 2;
                else {
                    add(node.left, nextLevel);
                    add(node.right, nextLevel);
                }
            }
            currentLevel = nextLevel;
            numOfNulls = 0;
        }
        return max;
    }

    private static void add(TreeNode node, List<TreeNode> nextLevel) {
        if(node == null) {
            if(nextLevel.size() > 0)
                numOfNulls++;
        } else {
            for(int i=0; i<numOfNulls; i++) {
                nextLevel.add(null);
            }
            numOfNulls = 0;
            nextLevel.add(node);
        }
    }
}
