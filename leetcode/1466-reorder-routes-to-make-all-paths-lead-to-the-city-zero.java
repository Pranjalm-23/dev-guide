import java.util.*;
import javafx.util.Pair;

class Solution {
    // recursively check for all neighbours in bfs way
    public int minReorder(int n, int[][] connections) {
        HashSet<Pair<Integer, Integer>> edges = new HashSet<>();
        for (int[] pair : connections)
            edges.add(new Pair<>(pair[0], pair[1]));

        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < n; i++)
            neighbors.put(i, new ArrayList<>());

        Set<Integer> visited = new HashSet<>();

        // fill neighbors irrespective of direction
        for (int[] pair : connections) {
            neighbors.get(pair[0]).add(pair[1]);
            neighbors.get(pair[1]).add(pair[0]);
        }

        visited.add(0);
        return dfsCheckneighborPath(0, visited, edges, neighbors);
    }

    private int dfsCheckneighborPath(int city, Set<Integer> visited, HashSet<Pair<Integer, Integer>> edges,
            Map<Integer, List<Integer>> neighbors) {
        int changes = 0;
        for (int neighbor : neighbors.get(city)) {
            if (visited.contains(neighbor))
                continue;
            if (!edges.contains(new Pair<>(neighbor, city)))
                changes += 1;
            visited.add(neighbor);
            changes += dfsCheckneighborPath(neighbor, visited, edges, neighbors);
        }
        return changes;
    }
}