// This is the solution I settled on, I struggled on this one because I didnt 
// consider using a table with dynamic programing until it was too late
class Solution {
	public int minCostClimbingStairs(int[] cost) {
		int prev = 0;
		int curr = 0;
		for (int i = 2; i <= cost.length; i++) {
			int one_jump = curr + cost[i-1];
			int two_jump = prev + cost[i-2];
			prev = curr;
			curr = Math.min(one_jump, two_jump);
		}
		return curr;
	}
}
// This was what I was originally going for I just refused to accept that keeping
// a table was all it took silly me, I should lean more on tables when the problem
// seems like dynamic programing meaning you can derive the answer by the previous answers

//class Solution {
//	public int minCostClimbingStairs(int[] cost) {
//		int total = 0;
//		int i = -1;
//		while (i < cost.length) {
//			if (cost[i+1] < cost[i+2]) {
//				total += cost[i+1];
//				i+=1;
//			} else {
//				total += cost[i+2];
//				i+=2;
//			}
//		}
//		return total;
//	}
//
//}
