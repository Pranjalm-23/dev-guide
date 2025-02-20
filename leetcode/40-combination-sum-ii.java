import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfsBacktrack(candidates, ans, new ArrayList<>(), 0, target);
        return ans;
    }

    private void dfsBacktrack(int[] candidates, List<List<Integer>> ans, List<Integer> cur, int idx, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target)
                break;
            if (i > idx && candidates[i] == candidates[i - 1])
                continue;
            cur.add(candidates[i]);
            dfsBacktrack(candidates, ans, cur, i + 1, target - candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
}