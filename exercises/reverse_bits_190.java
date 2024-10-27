// Easier to remember solution more straightforward
class Solution {
        public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res <<= 1;
			res |= (n & 1);
			n >>= 1;
		}
        return res;
    }
}
// Original solution I cam up with by swapping the mirrored bits
//class Solution {
//        public int reverseBits(int n) {
//		for (int i = 0; i < 16; i++) {
//			int left_bit = ((n >> (31 - i)) & 1);
//			int right_bit = ((n >> i) & 1);
//			if (left_bit != right_bit) {
//				n = n ^ (1 << (31 - i));
//                n = n ^ (1 << i);
//			}
//		}
//        return n;
//    }
//}


