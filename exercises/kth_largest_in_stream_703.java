import java.util.PriorityQueue;
import java.util.Arrays;

// Optimal Solution with efficient PriorityQueue population
class KthLargest {
	PriorityQueue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
		this.k = k;
        this.minHeap = new PriorityQueue<>(Math.max(k, 1));
        if (nums.length == 0) return;
        int toAdd = Math.min(nums.length, k);
        for (int i = 0; i < toAdd; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }
    public int add(int val) {
        if (minHeap.size() < this.k) minHeap.add(val);
        else if (val > minHeap.peek()) {
            minHeap.poll(); // Remove
			minHeap.add(val);
        }
		return minHeap.peek();
    }
}

// Alternative to Optimal Solution with possible useless optimization on add function
//class KthLargest {
//	PriorityQueue<Integer> minHeap;
//    int k;
//
//    public KthLargest(int k, int[] nums) {
//		this.k = k;
//        this.minHeap = new PriorityQueue<>(Math.max(k, 1));
//        if (nums.length == 0) return;
//        int toAdd = Math.min(nums.length, k);
//        for (int i = 0; i < toAdd; i++) {
//            minHeap.offer(nums[i]);
//        }
//        for (int i = k; i < nums.length; i++) {
//            if (nums[i] > minHeap.peek()) {
//                minHeap.poll();
//                minHeap.offer(nums[i]);
//            }
//        }
//    }
//    public int add(int val) {
//        if (minHeap.size() < k) {
//            minHeap.offer(val);
//            return minHeap.peek();
//        }
//        int smallest = minHeap.peek();
//        if (val > smallest) {
//            minHeap.poll();
//            minHeap.offer(val);
//            return minHeap.peek();
//        }
//        return smallest;
//    }
//}

// Original Solution (Slighty suboptimal)
//class KthLargest {
//	PriorityQueue<Integer> minHeap;
//    int k;
//
//    public KthLargest(int k, int[] nums) {
//		this.minHeap = new PriorityQueue<>();
//        this.k = k;
//		Arrays.sort(nums);
//		for(int i = nums.length -1; i >= nums.length - k && i >= 0; i--) {
//			minHeap.offer(nums[i]);
//		}   
//    }
//
//    public int add(int val) {
//        if (minHeap.size() < this.k) minHeap.add(val);
//        else if (val > minHeap.peek()) {
//            minHeap.poll(); // throw away
//			minHeap.add(val);
//        }
//		return minHeap.peek();
//    }
//}

