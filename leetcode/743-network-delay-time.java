import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adj = new int[n + 1][n + 1]; // wei
        for (int[] arr : adj)
            Arrays.fill(arr, -1);

        for (int[] arr : times) {
            adj[arr[0]][arr[1]] = arr[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // nei, wei
        Set<Integer> visit = new HashSet<>();
        int[] a = { k, 0 };
        pq.offer(a);
        int t = 0;

        while (pq.size() > 0) {
            int[] curr = pq.poll();

            if (visit.contains(curr[0]))
                continue;
            visit.add(curr[0]);
            t = Math.max(t, curr[1]);

            for (int i = 0; i < adj[curr[0]].length; i++) {
                if (!visit.contains(i) && adj[curr[0]][i] != -1) {
                    int[] b = { i, curr[1] + adj[curr[0]][i] };
                    pq.add(b);
                }
            }

        }

        return visit.size() == n ? t : -1;
    }
}