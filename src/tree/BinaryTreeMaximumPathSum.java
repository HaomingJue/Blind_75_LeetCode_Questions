package tree;

import utils.TreeNode;

public class BinaryTreeMaximumPathSum {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return ans;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = Math.max(maxGain(root.left), 0);
        int maxRight = Math.max(maxGain(root.right), 0);
        ans =  Math.max(maxLeft + root.val + maxRight, ans);
        return root.val + Math.max(maxLeft, maxRight);
    }
}
