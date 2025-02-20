import java.util.*;

class Solution {
    // used sets
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> posDia = new HashSet<>(); // r+c
    private Set<Integer> negDia = new HashSet<>(); // r-c

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] arr : board)
            Arrays.fill(arr, '.');
        return backtrack(board, 0);
    }

    private int backtrack(char[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int ans = 0;
        for (int col = 0; col < board.length; col++) {
            if (!cols.contains(col) && !posDia.contains(row + col) && !negDia.contains(row - col)) {
                board[row][col] = 'Q';
                cols.add(col);
                posDia.add(row + col);
                negDia.add(row - col);
                ans += backtrack(board, row + 1);
                board[row][col] = '.';
                cols.remove(col);
                posDia.remove(row + col);
                negDia.remove(row - col);
            }
        }
        return ans;
    }
}