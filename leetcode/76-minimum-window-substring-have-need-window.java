import java.util.*;

class Solution {
    // Time: O(n), Space: O(n), efficiently
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0
                || t.length() == 0 || s.length() < t.length())
            return "";

        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int ansStart = 0, ansEnd = 0;
        int have = 0, need = target.keySet().size();
        // Map<Character, Integer> window = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);

            if (target.containsKey(rc)) {
                // making target closer
                target.put(rc, target.get(rc) - 1);
                if (target.get(rc) == 0)
                    have++;
            }

            // achieved then Shrink
            while (have == need) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    ansStart = l;
                    ansEnd = r + 1;
                }

                char lc = s.charAt(l);
                if (target.containsKey(lc)) {
                    target.put(lc, target.get(lc) + 1);
                    if (target.get(lc) > 0)
                        have--;
                }
                l++;
            }
        }
        return s.substring(ansStart, ansEnd);
    }
}

class Solution2MAP {
    // takes O(n) time and O(n) space, but memory issue
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0
                || t.length() == 0 || s.length() < t.length())
            return "";

        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int ansStart = 0, ansEnd = 0;
        int have = 0, need = target.keySet().size();
        Map<Character, Integer> window = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);

            if (target.containsKey(rc)) {
                window.put(rc, window.getOrDefault(rc, 0) + 1);
                if (target.get(rc) == window.get(rc))
                    have++;
            }

            // check if achieved & Shrink
            while (have == need) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    ansStart = l;
                    ansEnd = r + 1;
                }

                char lc = s.charAt(l);
                if (window.containsKey(lc)) {
                    window.put(lc, window.get(lc) - 1);
                    if (target.get(lc) > window.get(lc))
                        have--;
                }
                l++;
            }
        }
        return s.substring(ansStart, ansEnd);
    }
}

class SolutionArray {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Frequency map for t
        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int have = 0, need = t.length();
        
        // Sliding window
        int[] windowFreq = new int[128];
        while (right < s.length()) {
            char rc = s.charAt(right);
            
            // Add to window
            if (targetFreq[rc] > 0) {
                windowFreq[rc]++;
                if (windowFreq[rc] <= targetFreq[rc]) {
                    have++;
                }
            }

            // Shrink the window
            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left);
                if (targetFreq[lc] > 0) {
                    if (windowFreq[lc] == targetFreq[lc]) {
                        have--;
                    }
                    windowFreq[lc]--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
