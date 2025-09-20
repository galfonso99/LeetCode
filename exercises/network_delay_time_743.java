import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// First working Solution (just do dfs) You could also do dijkstra's
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0],
            x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);

        dfs(k, 0, adj, dist);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int node, int time,
                     Map<Integer, List<int[]>> adj,
                     Map<Integer, Integer> dist) {
        if (time >= dist.get(node)) return;
        dist.put(node, time);
        if (!adj.containsKey(node)) return;
        for (int[] edge : adj.get(node)) {
            dfs(edge[0], time + edge[1], adj, dist);
        }
    }
}

// Shortest Path Faster Algorithm (Pretty much BFS)
// public class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         Map<Integer, List<int[]>> adj = new HashMap<>();
//         for (int i = 1; i <= n; i++) adj.put(i, new ArrayList<>());
//         for (int[] time : times) {
//             adj.get(time[0]).add(new int[] {time[1], time[2]});
//         }
//         Map<Integer, Integer> dist = new HashMap<>();
//         for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);
//         dist.put(k, 0);
//
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] {k, 0});
//
//         while (!q.isEmpty()) {
//             int[] curr = q.poll();
//             int node = curr[0], time = curr[1];
//             if (dist.get(node) < time) {
//                 continue;
//             }
//             for (int[] nei : adj.get(node)) {
//                 int nextNode = nei[0], weight = nei[1];
//                 if (time + weight < dist.get(nextNode)) {
//                     dist.put(nextNode, time + weight);
//                     q.offer(new int[] {nextNode, time + weight});
//                 }
//             }
//         }
//
//         int res = Collections.max(dist.values());
//         return res == Integer.MAX_VALUE ? -1 : res;
//     }
// }

// Bellman Ford Algorithm
// public class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         int[] dist = new int[n];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[k - 1] = 0;
//
//         for (int i = 0; i < n - 1; i++) {
//             for (int[] time : times) {
//                 int u = time[0] - 1, v = time[1] - 1, w = time[2];
//                 if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
//                     dist[v] = dist[u] + w;
//                 }
//             }
//         }
//
//         int maxDist = Arrays.stream(dist).max().getAsInt();
//         return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
//     }
// }
