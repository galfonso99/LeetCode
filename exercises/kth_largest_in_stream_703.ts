// This is a missplay never use Typescript for PriorityQueue
class KthLargest {
    k: number;
    heap: MinHeap;

    constructor(k: number, nums: number[]) {
        this.k = k;
        this.heap = new MinHeap();

        const toAdd = Math.min(nums.length, k);
        for (let i = 0; i < toAdd && i < nums.length; i++) {
            this.heap.add(nums[i]);
        }

        for (let i = k; i < nums.length; i++) {
            if (nums[i] > this.heap.getMin()) {
                this.heap.remove();
                this.heap.add(nums[i]);
            }
        }
    }

    add(val: number): number {
		if (val <= this.heap.getMin() && this.heap.getLength() == this.k) 
			return this.heap.getMin() 
        this.heap.add(val);
        if (this.heap.getLength()  > this.k) {
            this.heap.remove();
        }
        return this.heap.getMin();
    }
}


 class MinHeap {
     heap: (number | null)[];

     constructor() {
        this.heap = [null]
     }

     getMin() {
         return this.heap[1];
     }

     getLength() {
         return this.heap.length - 1;
     }

     heapify(array: number[]) {
        array.forEach(num => {
            this.add(num);
        })
     }

     add(val: number) {
        this.heap.push(val); 

        let currentIndex = this.heap.length - 1;
        let parentIndex = Math.floor(currentIndex / 2)

        while (currentIndex > 1 && this.heap[currentIndex] < this.heap[parentIndex]) {
            [this.heap[currentIndex], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[currentIndex]]

            currentIndex = parentIndex;
            parentIndex = Math.floor(parentIndex / 2)
        }
     }

     swap(a: number, b: number) {
         [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]]
     }

     remove() {
         if (this.heap.length <= 2) {
             this.heap = [null]
             return;
         }

        let removed = this.heap.pop();
        this.heap[1] = removed;

        let currentIndex = 1;
        let leftIndex =  2 * 1
        let rightIndex = 2 * 1 + 1;

        if (this.heap[leftIndex] === undefined) {
            return this.heap[1];
        }

        if (this.heap[rightIndex] === undefined) {
            if (this.heap[1] > this.heap[leftIndex]) {
                this.swap(currentIndex, leftIndex)
            } 
            return this.heap[1]
        }

        while(this.heap[currentIndex] > this.heap[leftIndex] || this.heap[currentIndex] > this.heap[rightIndex]) {
            if (this.heap[leftIndex] >= this.heap[rightIndex]) {
                this.swap(rightIndex, currentIndex)
                currentIndex = rightIndex;
            } else {
                this.swap(leftIndex, currentIndex)
                currentIndex = leftIndex;
            }

            leftIndex = currentIndex * 2;
            rightIndex = currentIndex * 2 + 1;
        }

        return this.heap[1];
     }
 }

