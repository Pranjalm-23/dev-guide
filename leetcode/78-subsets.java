import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        dfsBacktrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void dfsBacktrack(int[] nums, List<List<Integer>> ans, List<Integer> cur, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfsBacktrack(nums, ans, cur, i + 1);
        cur.remove(cur.size() - 1);
        dfsBacktrack(nums, ans, cur, i + 1);
    }
}