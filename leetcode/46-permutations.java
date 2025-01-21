import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();

        dfs(nums, ans, cur);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> cur) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int num : nums) {
            if (cur.contains(num))
                continue;

            cur.add(num);
            dfs(nums, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}