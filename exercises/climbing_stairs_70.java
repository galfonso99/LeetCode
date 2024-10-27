class Solution {
    public int climbStairs(int n) {
		// The answer for n is (n -1) + (n - 2)
		// This is because n has all the ways of (n - 1) but with a + 1 at the end
		// And all the ways of n - 2 but with a + 2 at the end
		if (n < 4) return n;
		int prev = 1;
		int curr = 2;
		for (int i = 3; i < n + 1; i++) {
			int new_ways = curr + prev;
			prev = curr;
			curr = new_ways;
		}
		return curr;
    }
}

// Slow fibonnacci Times out
//class Solution {
//    public int climbStairs(int n) {
//		if (n < 4) return n;
//		return climbStairs(n-1) + climbStairs(n-2);
//    }
//}


// Make a fast fibonacci
//class Solution {
//    public int climbStairs(int n) {
//		int[] arr = new int[n + 1];
//		return recurse(n, arr);
//    }
//	int recurse(int n, int[] arr) {
//		if (n < 4) return n;
//		if (arr[n] > 0) {
//			return arr[n];
//		}
//		arr[n] = recurse(n - 1, arr) + recurse(n - 2, arr);
//		return arr[n];
//	}
//}
