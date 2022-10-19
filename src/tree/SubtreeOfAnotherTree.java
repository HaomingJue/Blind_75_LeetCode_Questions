package tree;

import utils.TreeNode;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return root == null;
        }
        if (root == null) {
            return false;
        }
        if (isIdentical(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) {
            return false;
        }
        return root.val == subRoot.val && isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
}
