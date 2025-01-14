import java.util.Arrays;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
        for (int[] arr : memo)
            Arrays.fill(arr, 0);
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int l = dfs(i, j, matrix, memo, -1);
                if (l > ans)
                    ans = l;
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] memo, int preVal) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || preVal >= matrix[i][j])
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        int moreLen = 1;
        moreLen = Math.max(moreLen, 1 + dfs(i + 1, j, matrix, memo, matrix[i][j]));
        moreLen = Math.max(moreLen, 1 + dfs(i, j + 1, matrix, memo, matrix[i][j]));
        moreLen = Math.max(moreLen, 1 + dfs(i - 1, j, matrix, memo, matrix[i][j]));
        moreLen = Math.max(moreLen, 1 + dfs(i, j - 1, matrix, memo, matrix[i][j]));

        memo[i][j] = moreLen;
        return memo[i][j];
    }
}