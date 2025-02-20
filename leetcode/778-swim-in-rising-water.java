import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        // to store (maxHeight, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] { grid[0][0], 0, 0 });
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int height = curr[0], r = curr[1], c = curr[2];

            // bottom-right corner
            if (r == n - 1 && c == n - 1)
                return height;

            for (int[] dir : dirs) {
                int neiR = r + dir[0], neiC = c + dir[1];

                if (neiR >= 0 && neiC >= 0 && neiR < n && neiC < n && !visit[neiR][neiC]) {
                    visit[neiR][neiC] = true;
                    pq.offer(new int[] { Math.max(height, grid[neiR][neiC]), neiR, neiC });
                }
            }
        }
        return -1; // never
    }
}
