import java.util.*;

class SolutionUnionFind {
    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Condition: A tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(parent, rank, edge[0], edge[1])) {
                return false; // Cycle detected
            }
        }

        // If no cycle and correct number of edges, it's a tree
        return true;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]); // Path compression
        }
        return parent[node];
    }

    private boolean union(int[] parent, int[] rank, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        // roots are the same, a cycle is found
        if (rootA == rootB) {
            return false;
        }

        if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
}



class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition: A tree must have exactly n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // DFS with visited set and parent check
        Set<Integer> visited = new HashSet<>();
        if (!dfs(graph, visited, 0, -1)) {
            return false; // Cycle detected
        }

        // Check if all nodes are visited (ensuring connectivity)
        return visited.size() == n;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int parent) {
        visited.add(node);

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue; // Skip the node we came from
            }
            if (visited.contains(neighbor) || !dfs(graph, visited, neighbor, node)) {
                return false; // Cycle detected or DFS failed
            }
        }

        return true;
    }
}
