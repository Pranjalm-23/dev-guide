import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfsBacktrack(s, 0, 0, ans, "");
        return ans;
    }

    private void dfsBacktrack(String s, int i, int dots, List<String> ans, String curip) {
        if (dots > 4)
            return;
        if (dots == 4 && i == s.length()) {
            ans.add(curip.substring(0, curip.length() - 1));
            return;
        }

        for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            int n = Integer.parseInt(s.substring(i, j + 1));

            if (n < 256 && (i == j || s.charAt(i) != '0')) {
                dfsBacktrack(s, j + 1, dots + 1, ans, curip + n + '.');
            }
        }
    }
}