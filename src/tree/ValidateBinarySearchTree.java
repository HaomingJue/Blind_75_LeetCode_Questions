package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    private List<Integer> values;
    public boolean isValidBST(TreeNode root) {
        values = new ArrayList<>();
        inorderTraversal(root);
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) >= values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        values.add(root.val);
        inorderTraversal(root.right);
    }
}
