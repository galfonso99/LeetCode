import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Dijkstra's Approach
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        dist[src][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int cst = top[0], node = top[1], stops = top[2];
            if (node == dst) return cst;
            if (stops == k || dist[node][stops + 1] < cst) continue;
            for (int[] neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;
    }
}

// Bellman Ford Algorithm
// public class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[] prices = new int[n];
//         Arrays.fill(prices, Integer.MAX_VALUE);
//         prices[src] = 0;
//
//         for (int i = 0; i <= k; i++) {
//             int[] tmpPrices = Arrays.copyOf(prices, n);
//
//             for (int[] flight : flights) {
//                 int s = flight[0];
//                 int d = flight[1];
//                 int p = flight[2];
//
//                 if (prices[s] == Integer.MAX_VALUE) {
//                     continue;
//                 }
//
//                 if (prices[s] + p < tmpPrices[d]) {
//                     tmpPrices[d] = prices[s] + p;
//                 }
//             }
//
//             prices = tmpPrices;
//         }
//
//         return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
//     }
// }

// Shortest Path Faster Algorithm
// public class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         int[] prices = new int[n];
//         Arrays.fill(prices, Integer.MAX_VALUE);
//         prices[src] = 0;
//         List<int[]>[] adj = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             adj[i] = new ArrayList<>();
//         }
//         for (var flight : flights) {
//             adj[flight[0]].add(new int[] { flight[1], flight[2] });
//         }
//
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] { 0, src, 0 });
//
//         while (!q.isEmpty()) {
//             var curr = q.poll();
//             int cst = curr[0], node = curr[1], stops = curr[2];
//             if (stops > k) continue;
//
//             for (var neighbor : adj[node]) {
//                 int nei = neighbor[0], w = neighbor[1];
//                 int nextCost = cst + w;
//                 if (nextCost < prices[nei]) {
//                     prices[nei] = nextCost;
//                     q.offer(new int[] { nextCost, nei, stops + 1 });
//                 }
//             }
//         }
//         return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
//     }
// }

// First Attempt (Too slow for leetcode)
// class Solution {
// 	int cost = Integer.MAX_VALUE;
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
// 		List<ArrayList<int[]>> adj_list = new ArrayList<>();
// 		for (int i = 0; i < n; i++) {
// 			adj_list.add(new ArrayList<int[]>());
// 		}
// 		for (int i = 0; i < flights.length; i++) {
// 			int source = flights[i][0];
// 			adj_list.get(source).add(flights[i]);
// 		}
//         boolean[] visited = new boolean[n];
//         dfs(adj_list, visited, src, dst, k, 0);
// 		return this.cost == Integer.MAX_VALUE ? -1 : this.cost;
// 	}
//
// 	void dfs(List<ArrayList<int[]>> adj_list, boolean[] visited, int src, int dst, int k, int cost) {
// 		if (src == dst) {
//             this.cost = Math.min(cost, this.cost);
//             return;
//         }
// 		if (k < 0) return; 
//
// 		for (int[] neighbor : adj_list.get(src)) {
// 			int new_src = neighbor[1], new_cost = neighbor[2];
//             if (visited[new_src]) continue;
//             visited[new_src] = true;
// 			dfs(adj_list, visited, new_src, dst, k-1, cost + new_cost);
//             visited[new_src] = false;
// 		}
// 	}
// }
