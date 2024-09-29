import java.util.Arrays;
// Great Solution I found on LeetCode, really fast 
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
		int l = 1;
		int r = 1000000000;
        int ans = 1;
		while (l <= r) {
			int middle = (r + l) / 2;
			if (onTime(piles, middle, h)) {
                ans = middle;
                r = middle - 1;
			} else  {
				l = middle + 1;
			} 
		}
		return ans;
    }
	public boolean onTime(int[] array, int speed, int hours) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			count +=  (array[i] + speed - 1) / speed;
            if (count > hours) return false;
		}
        return true;
	}
}

// Even faster solution
//class Solution {
//    public int minEatingSpeed(int[] piles, int h) {
//        int n = piles.length;
//        long total = 0;
//        for(int p : piles){
//            total += p;
//        }
//        int left = (int) ((total - 1) / h) + 1;
//        int right = (int) ((total - n) / (h - n + 1)) + 1;
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            int time = 0;
//            for (int p : piles) {
//                time += (p - 1) / mid + 1;
//            }
//            if (time > h) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
//    }
//}

// My original solution
//class Solution {
//        public int minEatingSpeed(int[] piles, int h) {
//		Arrays.sort(piles);
//		int n = h / piles.length;
//		int l = piles[0] / n;
//		int r = piles[piles.length - 1] / n + 1;
//		while (l < r) {
//			int middle = l + (r - l) / 2;
//			int result = testEatingSpeed(piles, middle, h);
//			if (result == 1) {
//                l = middle + 1;
//			} else  {
//				r = middle;
//			} 
//		}
//		return l;
//
//    }
//	public int testEatingSpeed(int[] array, int speed, int hours) {
//		if (speed == 0) return 1;
//		int count = 0;
//		for (int i = 0; i < array.length; i++) {
//			count +=  array[i] / speed;
//            count += array[i] % speed > 0 ? 1 : 0;
//		}
//        return count < hours ? -1 : count > hours ? 1 : 0;
//	}
//
//}

// Thought Process
// Sort
// let m = hours / length
// left = array[0] / m
// right = array[array.length - 1]
// Do binary search from l to r on return value 0 set right to middle (do not return)
// for each iteration call a function that tests if the value uses all the hours (-1, 0, 1)

// piles = Arrays.stream(piles).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
// Alternative Arrays.sort() and then reverse the array using a for loop

//875. Koko Eating Bananas
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.
//
//
//[1000000,10000,100,1]  h=8
//
//Example 1:
//
//Input: piles = [3,6,7,11], h = 8
//1,2,2,3
//Output: 4
//
//Example 2:
//
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
//
//Example 3:
//
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
//
//
//
//Constraints:
//
//    1 <= piles.length <= 104
//    piles.length <= h <= 109
//    1 <= piles[i] <= 109
//
//
