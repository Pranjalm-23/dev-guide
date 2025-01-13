class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";
        int maxlen = 0;
        String ans = "" + s.charAt(0);

        for (int i = 0; i < s.length() - 1; i++) {
            // expand around for odd length
            String sub = getLongestSubstring(s, i, i);
            if (sub.length() > maxlen) {
                maxlen = sub.length();
                ans = sub;
            }
            // expand around for even
            sub = getLongestSubstring(s, i, i + 1);
            if (sub.length() > maxlen) {
                ans = sub;
                maxlen = sub.length();
            }
        }
        return ans;
    }

    private String getLongestSubstring(String s, int left, int right) {
        System.out.println(left + " " + right);
        int l = 0, r = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            l = left;
            r = right;
            left--;
            right++;
        }
        return s.substring(l, r + 1);
    }
}


// Best Runtime
class Solution2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd-length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindrome
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}