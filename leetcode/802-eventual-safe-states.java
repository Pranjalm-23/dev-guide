import java.util.*;

class SolutionDFS {
    // find nodes that don't lead to cycle
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashMap<Integer, Boolean> safe = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfsCheckIfSafe(graph, safe, i))
                ans.add(i);
        }
        return ans;
    }

    private boolean dfsCheckIfSafe(int[][] graph, HashMap<Integer, Boolean> safe, int curr) {
        if (safe.containsKey(curr))
            return safe.get(curr);
        safe.put(curr, false);
        for (int nei : graph[curr]) {
            if (!dfsCheckIfSafe(graph, safe, nei))
                return false;
        }
        safe.put(curr, true);
        return true;
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
            reverseGraph.add(new ArrayList<>());

        // Build reverse graph and calculate indegree
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
            }
            indegree[i] = graph[i].length; // Outgoing edges count
        }

        // Start with terminal nodes (indegree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS processing
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int parent : reverseGraph.get(node)) {
                indegree[parent]--;
                if (indegree[parent] == 0) {
                    queue.offer(parent);
                }
            }
        }

        Collections.sort(safeNodes); // Ensuring output order
        return safeNodes;
    }
}
