import java.util.HashMap;
import javafx.util.Pair;

class Solution {
    public boolean isMatch(String s, String p) {
        HashMap<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();
        return dfs(s, p, 0, 0, memo);
    }

    private boolean dfs(String s, String p, int i, int j, HashMap<Pair<Integer, Integer>, Boolean> memo) {
        Pair<Integer, Integer> key = new Pair(i, j);

        if (memo.containsKey(key))
            return memo.get(key);

        if (i >= s.length() && j >= p.length())
            return true;
        if (j >= p.length())
            return false;

        boolean match = (i < s.length()) && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'));

        if ((j + 1 < p.length()) && (p.charAt(j + 1) == '*')) {
            // don't use star || use star
            boolean possibility = (dfs(s, p, i, j + 2, memo) || (match && dfs(s, p, i + 1, j, memo)));
            memo.put(key, possibility);
            return possibility;
        }

        if (match) {
            boolean possibility = dfs(s, p, i + 1, j + 1, memo);
            memo.put(key, possibility);
            return possibility;
        }
        memo.put(key, false);
        return false;
    }
}