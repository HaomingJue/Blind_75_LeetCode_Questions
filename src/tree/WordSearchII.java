package tree;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    private List<String> ans = new ArrayList<>();
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, i, j, root);
            }
        }
        return ans;
    }

    private void backtracking(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];
        if (c == '*' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        board[i][j] = '*';
        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if (i_ >= 0 && j_ >= 0 && i_ < board.length && j_ < board[0].length) {
                backtracking(board, i_, j_, node);
            }
        }
        board[i][j] = c;
    }
}
