package bonus;

import utils.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(parent, root);
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        for (int i = 0; i < k; i++) {
            int qLen = q.size();
            for (int j = 0; j < qLen; j++) {
                TreeNode cur = q.poll();
                seen.add(cur);
                if (cur.left != null && !seen.contains(cur.left)) {
                    q.add(cur.left);
                }
                if (cur.right != null && !seen.contains(cur.right)) {
                    q.add(cur.right);
                }
                TreeNode curParent = parent.getOrDefault(cur, null);
                if (curParent != null && !seen.contains(curParent)) {
                    q.add(curParent);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }

    private void dfs(HashMap<TreeNode, TreeNode> parent, TreeNode root) {
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(parent, root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(parent, root.right);
        }
    }
}
