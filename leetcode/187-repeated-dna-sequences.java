import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for (int l = 0; l < s.length() - 9; l++) {
            String curr = s.substring(l, l + 10);
            if (set.contains(curr))
                if (!ans.contains(curr))
                    ans.add(curr);
            set.add(curr);
        }
        return ans;
    }
}