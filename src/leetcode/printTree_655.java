package leetcode;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class printTree_655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        int height = height(root);
        for(int i=0; i<height; i++) {
            List<String> currentLevel = new ArrayList<>();
            for(int j=0; j < Math.pow(2, height) - 1; j++) {
                currentLevel.add("");
            }
            ans.add(currentLevel);
        }

        updateMatrix(ans, root, 0, (int)Math.pow(2, height-1) - 1, (int) Math.pow(2, height-1));
        return ans;
    }

    private void updateMatrix(List<List<String>> ans, TreeNode node, int row, int col, int width){
        if(node == null || width == 0)
            return;
        ans.get(row).set(col, String.valueOf(node.val));
        updateMatrix(ans, node.left, row+1, col-width/2, width/2);
        updateMatrix(ans, node.right, row+1, col+width/2, width/2);
    }


    private int height(TreeNode node){
        if(node == null)    return 0;

        int left = height(node.left);
        int right = height(node.right);

        return 1 + Math.max(left, right);
    }
}
