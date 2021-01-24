package leetcode;

import leetcode.util.TreeNode;

import java.util.Arrays;

public class constructFromPrePost_889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        if(len == 0)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        if(len == 1)
            return node;

        int l = 0;
        for (int i = 0; i < len; ++i)
            if (post[i] == pre[1])
                l = i+1;


        node.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, l+1),
                Arrays.copyOfRange(post, 0, l));
        node.right = constructFromPrePost(Arrays.copyOfRange(pre, l+1, len),
                Arrays.copyOfRange(post, l, len-1));
        return node;
    }
}
