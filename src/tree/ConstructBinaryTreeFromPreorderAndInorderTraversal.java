package tree;

import utils.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        root.left = buildTree(preorder, left, inorderMap.get(root.val) - 1);
        root.right = buildTree(preorder, inorderMap.get(root.val) + 1, right);
        return root;
    }
}
