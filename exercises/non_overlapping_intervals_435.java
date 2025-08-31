import java.util.Arrays;

// Original working solution
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

		int[] prev_interval = intervals[0];
		int removed = 0;

		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];

			if (interval[0] < prev_interval[1]) { // they overlap
				removed++;
				prev_interval = interval[1] < prev_interval[1] ? interval : prev_interval;
			} else {
                prev_interval = interval;
            }
		}
		return removed;
    }
}

// TURNS OUT INTEGER.COMPARE IS REALLY SLLLLOOOOOOWWWWW
// Optimized alternative
// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         if (intervals.length <= 1) return 0;
//         Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
//
//         int count = 1; 
//         int lastEnd = intervals[0][1];
//
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i][0] >= lastEnd) { // No overlap
//                 count++;
//                 lastEnd = intervals[i][1];
//             }
//         }
//         return intervals.length - count;
//     }
// }
