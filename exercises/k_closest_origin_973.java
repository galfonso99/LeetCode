import java.util.PriorityQueue;
class Solution {
    public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
		int[][] res = new int[k][2];
		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
            if (maxHeap.size() < k) {
                int value = point[0] * point[0] + (point[1] * point[1]);
                maxHeap.offer(new Integer[] {value, i});
            } else  {
                int value = point[0] * point[0] + (point[1] * point[1]);
                if (value < maxHeap.peek()[0]) {
                    maxHeap.poll();
                    maxHeap.offer(new Integer[] {value, i});
                }
            }
		}
		int i = 0;
        for (var element : maxHeap) {
            res[i] = points[element[1]];
			i++;
        }
		return res;
    }
}
