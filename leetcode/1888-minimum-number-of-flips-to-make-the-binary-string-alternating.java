class Solution {
    public int minFlips(String s) {
        int n = s.length();
        s = s + s;
        StringBuilder alt1 = new StringBuilder(), alt2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            alt1.append(i % 2 == 0 ? '0' : '1'); // Pattern "0101..."
            alt2.append(i % 2 == 0 ? '1' : '0'); // Pattern "1010..."
        }

        int res = n;
        int l = 0;
        int diff1 = 0, diff2 = 0;
        for (int r = 0; r < s.length(); r++) {
            // expand
            if (s.charAt(r) != alt1.charAt(r))
                diff1++;
            if (s.charAt(r) != alt2.charAt(r))
                diff2++;

            if ((r - l + 1) > n) {
                // shrink
                if (s.charAt(l) != alt1.charAt(l))
                    diff1--;
                if (s.charAt(l) != alt2.charAt(l))
                    diff2--;
                l++;
            }

            if ((r - l + 1) == n) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
        return res;
    }
}