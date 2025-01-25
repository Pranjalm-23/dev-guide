import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        backtrack(n, 0, 0, ans, cur);
        return ans;
    }

    private void backtrack(int n, int o, int c, List<String> ans, StringBuilder cur) {
        if (o == n && c == n) {
            ans.add(cur.toString());
            return;
        }

        if (o < n) {
            cur.append('(');
            backtrack(n, o + 1, c, ans, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (c < o) {
            cur.append(')');
            backtrack(n, o, c + 1, ans, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}