package tree;

import utils.TreeNode;

import java.util.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack =  new Stack<>();
        int count = 0;
        TreeNode node =  root;
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                TreeNode cur = stack.pop();
                count++;
                if (count == k) {
                    return cur.val;
                }
                node = cur.right;
            }
        }
    }
}
