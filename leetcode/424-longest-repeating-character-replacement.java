import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> window = new HashMap<>();
        int maxLen = 0, maxF = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            // expand
            char rc = s.charAt(r);
            window.put(rc, window.getOrDefault(rc, 0) + 1);
            maxF = Math.max(maxF, window.get(rc));

            while (r - l + 1 - maxF > k) {
                // shrink
                char lc = s.charAt(l);
                window.put(lc, window.get(lc) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}