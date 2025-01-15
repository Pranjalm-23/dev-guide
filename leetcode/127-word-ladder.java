import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int level = 0;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(endWord))
                    return level;

                // add all neighbors
                for (int j = 0; j < word.length(); j++) {
                    char[] wordArr = word.toCharArray();
                    // trying all possibilities
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String nei = new String(wordArr);
                        if (set.contains(nei)) {
                            q.offer(nei);
                            set.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}