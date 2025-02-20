class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class WordDictionary {
    private final TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new TrieNode();
            curr = curr.children[ch - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, this.root);
    }

    public boolean dfsSearch(String word, int i, TrieNode root) {
        if (root == null)
            return false;
        if (i == word.length())
            return root.isEndOfWord;
        char c = word.charAt(i);
        if (c == '.') {
            for (TrieNode child : root.children) {
                if (child != null && dfsSearch(word, i + 1, child))
                    return true;
            }
            return false;
        } else {
            return dfsSearch(word, i + 1, root.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */