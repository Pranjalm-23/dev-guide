import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfsBacktrack(n, k, 1, ans, new ArrayList<>());
        return ans;
    }

    private void dfsBacktrack(int n, int k, int start, List<List<Integer>> ans, List<Integer> cur) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            dfsBacktrack(n, k, i + 1, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}