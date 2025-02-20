import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfsBacktrack(nums, ans, new ArrayList<>(), used);
        return ans;
    }

    private void dfsBacktrack(int[] nums, List<List<Integer>> ans, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                // duplicates to be used in the same branch only!
                continue;
            int num = nums[i];

            cur.add(num);
            used[i] = true;
            dfsBacktrack(nums, ans, cur, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}