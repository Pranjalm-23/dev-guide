import java.util.*;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        // build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        // dfs
        Set<String> result = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, TrieNode node, int r, int c, Set<String> result) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];
        int idx = ch - 'a';
        if (node.children[idx] == null) {
            return;
        }
        node = node.children[idx];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[r][c] = '#'; // Mark as visited

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] del : dir) {
            dfs(board, node, r + del[0], c + del[1], result);
        }

        board[r][c] = ch; // Restore the character

    }
}

class TrieNode {
    String word;
    TrieNode[] children;

    TrieNode() {
        this.children = new TrieNode[26];
    }
}