import java.util.LinkedList;
import java.util.PriorityQueue;

// Math Algorithm Solution
class Solution {
	public int leastInterval(char[] tasks, int n) {
		// Count frequencies
		int[] freq = new int[26];
		for (char task : tasks) {
			freq[task - 'A']++;
		}
		// Find max frequency and count of tasks with max frequency
		int maxFreq = 0, maxCount = 0;
		for (int f : freq) {
			if (f > maxFreq) {
				maxFreq = f;
				maxCount = 1;
			} else if (f == maxFreq) {
				maxCount++;
			}
		}
		int maxTasksCycles = maxFreq - 1;
		int gapsBetweenCycles = n - (maxCount - 1);
		int emptySlots = maxTasksCycles * gapsBetweenCycles;
		int availableTasks = tasks.length - maxFreq * maxCount;
		int idleSlots = Math.max(0, emptySlots - availableTasks);
		return tasks.length + idleSlots;
	}
}

// Priority Queue Solution (inefficient)
//class Solution {
//    public int leastInterval(char[] tasks, int n) {
//        int[] freq = new int[26];
//        for (char c : tasks) {
//            freq[c - 'A']++;
//        }
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//        for (int f : freq) {
//            if (f > 0) pq.offer(f);
//        }
//
//        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
//        int time = 0;
//
//        while (!pq.isEmpty() || !q.isEmpty()) {
//            time++;
//
//            if (!pq.isEmpty()) {
//                int cnt = pq.poll() - 1;
//
//                if (cnt != 0) {
//                    q.offer(new Pair(cnt, time + n));
//                }
//            }
//
//            if (!q.isEmpty() && q.peek().getValue() == time) {
//                pq.offer(q.poll().getKey());
//            }
//        }
//
//        return time;
//    }
//}
