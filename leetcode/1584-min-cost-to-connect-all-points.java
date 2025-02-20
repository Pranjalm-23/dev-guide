import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>(); // adj[node] -> {cost, neighbor}

        for (int i = 0; i < n; i++)
            adj.put(i, new ArrayList<>());

        // Build adjacency list with Manhattan distances
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) { // Avoid duplicate edges
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.get(i).add(new int[] { dist, j });
                adj.get(j).add(new int[] { dist, i });
            }
        }

        // Prim's Algorithm
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // Min-heap (cost, node)
        pq.offer(new int[] { 0, 0 }); // Start with node 0
        int minCost = 0;

        while (visit.size() < n) {
            int[] edge = pq.poll();
            int cost = edge[0], node = edge[1];

            if (visit.contains(node))
                continue;
            visit.add(node);
            minCost += cost;

            for (int[] neighbor : adj.get(node)) {
                int nextCost = neighbor[0], nextNode = neighbor[1];
                if (!visit.contains(nextNode)) {
                    pq.offer(new int[] { nextCost, nextNode });
                }
            }
        }
        return minCost;
    }
}

// Kruskal’s Algorithm with Union-Find
class SolutionKruskalUF {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        // Step 1: Compute all possible edges and sort by cost (Manhattan distance)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] { dist, i, j });
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[0])); // Sort by distance

        // Step 2: Kruskal’s Algorithm with Union-Find
        UnionFind uf = new UnionFind(n);
        int minCost = 0, edgesUsed = 0;

        for (int[] edge : edges) {
            int cost = edge[0], u = edge[1], v = edge[2];
            if (uf.union(u, v)) { // If merged successfully, add cost
                minCost += cost;
                edgesUsed++;
                if (edgesUsed == n - 1)
                    break; // MST is complete
            }
        }
        return minCost;
    }
}

// Union-Find (Disjoint Set Union) with Path Compression & Union by Rank
class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path Compression
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY)
            return false; // Already connected

        // Union by Rank
        if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
