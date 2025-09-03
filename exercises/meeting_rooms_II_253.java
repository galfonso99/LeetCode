import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// MinHeap
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}

// Sweep Line Algorithm
// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         TreeMap<Integer, Integer> mp = new TreeMap<>();
//         for (Interval i : intervals) {
//             mp.put(i.start, mp.getOrDefault(i.start, 0) + 1);
//             mp.put(i.end, mp.getOrDefault(i.end, 0) - 1);
//         }
//         int prev = 0;
//         int res = 0;
//         for (int key : mp.keySet()) {
//             prev += mp.get(key);
//             res = Math.max(res, prev);
//         }
//         return res;
//     }
// }

// Original working solution Prob (O(n^2))
// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         if (intervals.size() < 1) return 0;
// 		intervals.sort((a,b) -> a.start - b.start);
// 		List<Interval> list = new ArrayList<>();
// 		list.add(intervals.get(0));
// 		for (int i = 1; i < intervals.size(); i++) {
// 			Interval curr = intervals.get(i);
// 			boolean resolved = false;
// 			for (int j = list.size() - 1; j >= 0; j--) {
// 				Interval prev = list.get(j);
// 				if (curr.start >= prev.end) {
// 					list.set(j, curr);
//                     resolved = true;
// 					break;
// 				}
// 			}
// 			if (!resolved) {
// 				list.add(curr);
// 			}
// 		}
// 		return list.size();
//     }
// }
