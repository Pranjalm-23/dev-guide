import java.util.*;

class SolutionBacktrack {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<String>();
        for (String s : nums)
            set.add(s);
        return dfs("", set, nums[0].length());
    }

    private String dfs(String s, Set<String> set, int n) {
        if (s.length() == n) {
            if (!set.contains(s))
                return s;
            return null;
        }
        String a = dfs(s + '0', set, n);
        if (a != null)
            return a;
        return dfs(s + '1', set, n);

    }

}

// using diagonal argument trick
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder uniqueString = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            // Flip the i-th bit of the i-th string
            uniqueString.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return uniqueString.toString();
    }
}