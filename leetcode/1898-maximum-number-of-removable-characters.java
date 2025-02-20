class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (possible(s, p, removable, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean possible(String s, String p, int[] removable, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < k; i++) {
            str[removable[i]] = '*';
        }

        int idx = 0; // for p

        for (char c : str) {
            if (idx < p.length() && c == p.charAt(idx))
                idx++;
        }
        return idx == p.length();
    }
}