import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, int i, List<List<Integer>> ans, List<Integer> cur) {
        if (i > nums.length)
            return;
        if (i == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, i + 1, ans, cur);
        cur.remove(cur.size() - 1);
        // for branch having none of the duplicates
        while (((i + 1) < nums.length) && (nums[i] == nums[i + 1]))
            i += 1;
        backtrack(nums, i + 1, ans, cur);
    }
}