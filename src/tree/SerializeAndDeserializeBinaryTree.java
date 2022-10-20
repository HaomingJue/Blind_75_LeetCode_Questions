package tree;

import utils.TreeNode;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    private void serialize(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("n,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serialize(sb, root.left);
        serialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] decodeStr = data.split(",");
        TreeNode root = deserialize(decodeStr);
        return root;
    }

    private int i = 0;

    private TreeNode deserialize(String[] decodeStr) {
        if (i >= decodeStr.length) {
            return null;
        }
        if (decodeStr[i].equals("n")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(decodeStr[i]));
        i++;
        root.left = deserialize(decodeStr);
        i++;
        root.right = deserialize(decodeStr);
        return root;
    }
}
