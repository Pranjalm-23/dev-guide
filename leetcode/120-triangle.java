import java.util.List;

class SolutionDFS {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfsTotal(triangle, 0, 0, new Integer[triangle.size()][triangle.size()]);
    }

    private int dfsTotal(List<List<Integer>> triangle, int r, int c, Integer[][] memo) {
        if (r == memo.length)
            return 0;
        if (memo[r][c] != null)
            return memo[r][c];

        int curr = triangle.get(r).get(c)
                + Math.min(dfsTotal(triangle, r + 1, c, memo), dfsTotal(triangle, r + 1, c + 1, memo));
        memo[r][c] = curr;
        return curr;
    }
}

class SolutionDP {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int r = n - 2; r >= 0; r--) {
            List<Integer> curr = triangle.get(r);
            for (int i = 0; i < curr.size(); i++) {
                dp[i] = curr.get(i) + Math.min(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }
}