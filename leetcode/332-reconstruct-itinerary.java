import java.util.*;

class SolutionDFS {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> edge : tickets) {
            String from = edge.get(0);
            String to = edge.get(1);
            if (!adj.containsKey(from))
                adj.put(from, new PriorityQueue<>());
            adj.get(from).offer(to);
        }
        LinkedList<String> ans = new LinkedList<>();
        dfsBackTrack("JFK", adj, ans);
        return ans;
    }

    private void dfsBackTrack(String src, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> ans) {
        PriorityQueue<String> dests = adj.get(src);

        while (dests != null && !dests.isEmpty()) {
            dfsBackTrack(dests.poll(), adj, ans);
        }
        ans.addFirst(src);
    }
}