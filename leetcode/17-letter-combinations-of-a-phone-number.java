import java.util.*;

class Solution {
    private String[] keyMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        dfsBacktrack(digits, 0, "", ans);
        return ans;
    }

    private void dfsBacktrack(String digits, int i, String cur, List<String> ans) {
        if (i == digits.length()) {
            if (cur.length() > 0)
                ans.add(cur);
            return;
        }
        int d = digits.charAt(i) - '0';
        for (int j = 0; j < keyMap[d].length(); j++) {
            dfsBacktrack(digits, i + 1, cur + keyMap[d].charAt(j), ans);
        }
    }
}