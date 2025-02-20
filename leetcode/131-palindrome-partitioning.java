import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<List<String>>();
        dfsBacktrack(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void dfsBacktrack(String s, List<List<String>> ans, List<String> curr, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                curr.add(str);
                dfsBacktrack(s, ans, curr, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}