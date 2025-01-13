class Solution {
    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd
            ans += countSubs(s, i, i);
            // even
            if (i + 1 < s.length()) {
                ans += countSubs(s, i, i + 1);
            }
        }
        return ans;
    }

    private int countSubs(String s, int l, int r) {
        int c = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            c++;
            l--;
            r++;
        }
        return c;
    }
}