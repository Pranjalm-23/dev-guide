import java.util.*;
import javafx.util.Pair;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<String>();
        for (String s : deadends)
            deads.add(s);
        if (deads.contains("0000"))
            return -1;

        Queue<Pair<String, Integer>> q = new ArrayDeque<>(); // currLock, Nturns
        Set<String> visited = deads; // deadends and visited both are not to be continued furthur
        q.offer(new Pair<>("0000", 0));

        while (q.size() > 0) {
            Pair<String, Integer> curr = q.poll();
            if (curr.getKey().equals(target))
                return curr.getValue();

            for (String child : children(curr.getKey())) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    q.offer(new Pair<>(child, curr.getValue() + 1));
                }
            }

        }
        return -1;
    }

    private List<String> children(String s) {
        List<String> childs = new ArrayList<>();
        char[] ch = s.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = ch[i];

            // forward
            ch[i] = (char) ((original == '9') ? '0' : original + 1);
            childs.add(new String(ch));

            // backward
            ch[i] = (char) ((original == '0') ? '9' : original - 1);
            childs.add(new String(ch));

            // Restore
            ch[i] = original;
        }

        return childs;
    }
}