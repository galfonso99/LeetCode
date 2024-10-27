class Solution {
	public int[] countBits(int n) {
		int bit = 0;
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			int square = 1 << bit;
			if (i == (square << 1)) {
				bit += 1;
				square <<= 1; 
			}
			int diff = i - square;
			arr[i] = arr[diff] + 1;
		}
		return arr;
	}
}
