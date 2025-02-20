import java.util.Arrays;
import java.util.*;

class SolutionBellmanFord {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] prices = Arrays.copyOf(ans, n); // Temporary array

            for (int[] ticket : flights) {
                int from = ticket[0], to = ticket[1], cost = ticket[2];

                if (ans[from] == Integer.MAX_VALUE)
                    continue;
                prices[to] = Math.min(prices[to], ans[from] + cost);
            }

            ans = prices;
        }

        return ans[dst] == Integer.MAX_VALUE ? -1 : ans[dst];
    }
}
class SolutionDijsktraBFS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], val -> new ArrayList<>()).add(new int[] { flight[1], flight[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, src, k + 1 }); // (cost, node, stops left)

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stops = curr[2];

            if (node == dst)
                return cost; // Found the cheapest path

            if (stops > 0) { // can still make stops
                for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    pq.offer(new int[] { cost + neighbor[1], neighbor[0], stops - 1 });
                }
            }
        }

        return -1;
    }
}
