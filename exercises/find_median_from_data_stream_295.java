import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

// More performant variation of the two priority queues approach
class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        this.small = new PriorityQueue<Integer>((a, b) -> b - a);
        this.large = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (small.isEmpty()) {
            small.offer(num);
        } else if(small.peek() <= num) {
            large.offer(num);
        } else {
            small.offer(num);
        }

        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        } else if(large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else if(small.size() > large.size()) {
            return small.peek();
        } else {
            return large.peek();
        }
    }
}

// Original working solution
// class MedianFinder {
// 	Queue<Integer> maxHeap; 
// 	Queue<Integer> minHeap; 
//
//     public MedianFinder() {
// 		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
// 		minHeap = new PriorityQueue<>();
//     }
//
//     public void addNum(int num) {
// 		maxHeap.offer(num);
//
// 		minHeap.offer(maxHeap.poll());
//
// 		if (maxHeap.size() < minHeap.size()) {
// 			maxHeap.offer(minHeap.poll());
// 		}
//     }
//
//     public double findMedian() {
// 		if (maxHeap.size() > minHeap.size()) {
// 			return maxHeap.peek();
// 		} else {
// 			return (minHeap.peek() + maxHeap.peek()) / 2.0;
// 		}
//     }
// }
