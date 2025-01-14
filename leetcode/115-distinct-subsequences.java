import java.util.Arrays;

class Solutiondfs {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        int[][] cache = new int[s.length() + 1][t.length() + 1];
        for (int[] arr : cache)
            Arrays.fill(arr, -1);
        return dfs(s, 0, t, 0, cache);

    }

    private int dfs(String s, int i, String t, int j, int[][] cache) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;

        if (cache[i][j] != -1)
            return cache[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            // take + dont
            cache[i][j] = dfs(s, i + 1, t, j + 1, cache) + dfs(s, i + 1, t, j, cache);
        } else {
            // dont
            cache[i][j] = dfs(s, i + 1, t, j, cache);
        }
        return cache[i][j];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length())
            return 0;
        int[][] cache = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            cache[i][t.length()] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    cache[i][j] = cache[i + 1][j + 1] + cache[i + 1][j];
                } else {
                    cache[i][j] = cache[i + 1][j];
                }
            }
        }
        return cache[0][0];
    }
}