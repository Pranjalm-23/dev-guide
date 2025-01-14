import java.util.Arrays;
import java.util.HashMap;

class SolutionDFS {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        HashMap<String, Boolean> memo = new HashMap<>();
        return dfs(s1, s2, s3, 0, 0, memo);
    }

    private Boolean dfs(String s1, String s2, String s3, int i, int j, HashMap<String, Boolean> memo) {
        if (i == s1.length() && j == s2.length())
            return true;
        String key = i + " " + j;
        if (memo.containsKey(key))
            return memo.get(key);

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(s1, s2, s3, i + 1, j, memo))
            return true;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(s1, s2, s3, i, j + 1, memo))
            return true;
        return false;
    }
}

// fast runtime
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        for (Boolean[] arr : dp)
            Arrays.fill(arr, false);
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                System.out.println(dp[i][j]);
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }
}