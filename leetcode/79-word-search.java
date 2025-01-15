class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int r, int c) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(i)) {
            return false;
        }

        char ch = board[r][c];
        board[r][c] = '#'; // Mark as visited

        boolean ans = dfs(board, word, i + 1, r + 1, c)
                || dfs(board, word, i + 1, r - 1, c)
                || dfs(board, word, i + 1, r, c + 1)
                || dfs(board, word, i + 1, r, c - 1);

        board[r][c] = ch; // Restore the character
        return ans;
    }
}
