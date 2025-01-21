import java.util.*;

class Solution {
    // used sets
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> posDia = new HashSet<>(); // r+c
    private Set<Integer> negDia = new HashSet<>(); // r-c

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] arr : board)
            Arrays.fill(arr, '.');
        backtrack(board, 0, ans);
        return ans;
    }

    private void backtrack(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(constructSolution(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (!cols.contains(col) && !posDia.contains(row + col) && !negDia.contains(row - col)) {
                board[row][col] = 'Q';
                cols.add(col);
                posDia.add(row + col);
                negDia.add(row - col);
                backtrack(board, row + 1, ans);
                board[row][col] = '.';
                cols.remove(col);
                posDia.remove(row + col);
                negDia.remove(row - col);
            }
        }
    }

    private List<String> constructSolution(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (char[] arr : board)
            ans.add(String.valueOf(arr));
        return ans;
    }
}