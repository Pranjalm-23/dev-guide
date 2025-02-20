import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> q = new ArrayDeque<>(); // squareNo, moves
        Set<Integer> visit = new HashSet<>();
        q.offer(new int[] { 1, 0 });
        visit.add(1);

        while (q.size() > 0) {
            int[] curr = q.poll();// squareNo, moves
            for (int i = 1; i < 7; i++) {
                int nextSquare = curr[0] + i;
                int[] rc = intToPosition(nextSquare, n);

                if (board[rc[0]][rc[1]] != -1)
                    nextSquare = board[rc[0]][rc[1]];

                if (nextSquare == n * n)
                    return curr[1] + 1; // moves + 1

                if (!visit.contains(nextSquare)) {
                    visit.add(nextSquare);
                    q.offer(new int[] { nextSquare, curr[1] + 1 });
                }
            }
        }
        return -1;
    }

    private int[] intToPosition(int square, int n) {
        // note, the board is inverted
        int r = n - 1 - (square - 1) / n; // row index 0 at bottom
        int c = (square - 1) % n;

        if ((n - 1 - r) % 2 == 1) // Odd rows from bottom go right-to-left
            c = n - 1 - c;

        return new int[] { r, c };
    }
}