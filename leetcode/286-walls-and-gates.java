import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        // Add all gates to the queue
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) q.offer(new int[]{r, c});
            }
        }

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int INF = Integer.MAX_VALUE; // Representing an empty room

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || rooms[nr][nc] != INF) continue;

                    rooms[nr][nc] = rooms[r][c] + 1; // Update distance
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
