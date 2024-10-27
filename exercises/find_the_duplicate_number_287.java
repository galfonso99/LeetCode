// the reason this algorithm works is that 
// let x be dist from start to beginning of cycle
// let y be dist from beg of cycle to where the pointers meet
// let z be dist from the meeting point back again to the beginning of the cycle
// let c be the circumference of the cycle
// we can say that twice the distance traveled by slow is equal to the dist traveled by fast
// 2(x+y) = x + n(c) + y        where n is the amount of loops of c
// (x+y) + (x+y) = x + n(c) + y
// x+y = n(c)
// x = n(c) - y
// from this we can see that by the time slow gets to the beginning of the cycle (x)
// fast pointer moves y steps back (ending at the beginning of the cycle) and then performs
// n loops around the cycle ultimately ending at the beginning once again
// this way we can tell that slow and fast will indeed meet at the beginning of the cycle
// which is the duplicate we were looking for
//
class Solution {
	public int findDuplicate(int[] A) {
		int slow = 0;
		int fast = 0;
		while (true) {
			slow = A[slow];
			fast = A[A[fast]];
			if (slow == fast) break;
		}
		slow = A[0];
		while (slow != fast) {
			slow = A[slow];
			fast = A[A[fast]];
		}
		return slow;
	}
}
