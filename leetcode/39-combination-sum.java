import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfsBackTrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfsBackTrack(int[] candidates, int target, int i, List<Integer> cur, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        } else if (target < 0)
            return;

        for (int j = i; j < candidates.length; j++) {
            cur.add(candidates[j]);
            dfsBackTrack(candidates, target - candidates[j], j, cur, ans);
            cur.remove(cur.size() - 1);

        }

    }
}