// Original Solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
      	PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);  
		for (int i = 0; i < k; i++) {
			minHeap.add(nums[i]);	
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] <= minHeap.peek()) continue;	
			minHeap.poll();
			minHeap.add(nums[i]);
		}
		return minHeap.peek();
    }
}
// Cheating method exploiting the input constrains and using an array instead of a priority queue
//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        int[] count = new int[20002];
//        for(int i =0;i<nums.length;i++) {
//            count[nums[i]+10000]++;
//        }
//        for (int i = count.length-1;i>=0;i--) {
//            k = k - count[i];
//            if (k <= 0) return i-10000;
//        }
//        return 0;
//    }
//}
