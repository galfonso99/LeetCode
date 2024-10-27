import java.util.PriorityQueue;
class Solution {
    public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, (a,b) -> b - a);
		for (int i = 0; i < stones.length; i++) {
			//pq.add(new Integer(stones[i]));
			pq.add(stones[i]);
		}
		System.out.println(stones);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		pq.
		return 7;
    }
}
