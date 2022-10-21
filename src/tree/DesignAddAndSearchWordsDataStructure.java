package tree;

public class DesignAddAndSearchWordsDataStructure {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            return search(node.children[c - 'a'], word, index + 1);
        }
        else {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && search(node.children[j], word, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
