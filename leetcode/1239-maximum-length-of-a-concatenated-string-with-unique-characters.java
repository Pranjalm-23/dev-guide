import java.util.*;

class Solution {
    public int maxLength(List<String> arr) {
        Set<Character> set = new HashSet<>();
        return backtrack(arr, 0, set);
    }

    private int backtrack(List<String> arr, int i, Set<Character> set) {
        if (i == arr.size())
            return set.size();
        int res = 0;

        if (dontOverlap(set, arr.get(i))) {
            for (char c : arr.get(i).toCharArray())
                set.add(c);
            res = backtrack(arr, i + 1, set);
            for (char c : arr.get(i).toCharArray())
                set.remove(c);
        }
        return Math.max(res, backtrack(arr, i + 1, set));
    }

    private boolean dontOverlap(Set<Character> set, String s) {
        Set<Character> prev = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c) || prev.contains(c))
                return false;
            prev.add(c);
        }
        return true;
    }
}