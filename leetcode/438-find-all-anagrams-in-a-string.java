import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length())
            return ans;

        char sc[] = new char[256];
        char pc[] = new char[256];
        for (int i = 0; i < p.length(); i++) {
            sc[s.charAt(i)]++;
            pc[p.charAt(i)]++;
        }
        if (Arrays.equals(sc, pc))
            ans.add(0);
        // for constant window size
        for (int j = p.length(); j < s.length(); j++) {
            sc[s.charAt(j)]++;
            sc[s.charAt(j - p.length())]--;
            if (Arrays.equals(sc, pc))
                ans.add(j - p.length() + 1);
        }
        return ans;
    }
}