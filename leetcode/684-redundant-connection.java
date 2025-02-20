class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!union(parent, rank, u, v)) {
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int n) {
        if (parent[n] != n)
            parent[n] = find(parent, parent[n]);
        return parent[n];
    }

    private boolean union(int[] parent, int[] rank, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA == rootB)
            return false;

        if (rank[rootA] > rank[rootB])
            parent[rootB] = rootA;
        else if (rank[rootA] < rank[rootB])
            parent[rootA] = rootB;
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;

    }
}