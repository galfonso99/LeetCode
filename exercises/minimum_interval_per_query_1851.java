import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Actual Solution O(nlogn + mlogm)
// The inner loops run independently from the outer loop and only run once overall for each interval
// Making it additive not multiplicative
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                minHeap.offer(new int[]{r - l + 1, r});
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}

// First passing Solution (On neetcode) , but very slow n^2
// class Solution {
//     public int[] minInterval(int[][] intervals, int[] queries) {
// 		Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : (a[1] - a[0]) - (b[1] - b[0]));
// 		int[] res = new int[queries.length];
// 		Arrays.fill(res, -1);
// 		for (int j = 0; j < queries.length; j++) {
// 			for (int i = 0; i < intervals.length; i++) {
// 				if (intervals[i][0] <= queries[j] && queries[j] <= intervals[i][1]) {
//                     int curr_length = intervals[i][1] - intervals[i][0] + 1;
// 					res[j] = res[j] == -1 || res[j] > curr_length ? curr_length : res[j];
// 				}
// 			}
// 		}
// 		return res;
//     }
// }

