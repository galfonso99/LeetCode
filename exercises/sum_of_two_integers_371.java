// More complicated solution that strictly sticks to the rule of no addition or subtraction
class Solution {
    public int getSum(int a, int b) {
		int res = 0;
		int carry = 0;
        // To avoid the use of plus sign in the upkeep of the loop, we have to do some weird shiFt (without the F), pun intended
		for (int bitMask = 1; bitMask != 0; bitMask <<= 1) {
            int i = Integer.numberOfTrailingZeros(bitMask);    // variable i goes from 0 to 31
			int aBit = (a >> i) & 1; 
			int bBit = (b >> i) & 1; 
			int resultBit = 0;

			if (aBit == 0 && bBit == 0) {
				resultBit = carry;
				carry = 0;
			} else if (aBit == 1 && bBit == 1) {
				resultBit = carry;
				carry = 1;
			} else {
				resultBit = (aBit | bBit) ^ carry;
			}

			res |= (resultBit << i);
		}
		return res;
	}
}

// Straightforward solution that allows the use of addition for the upkeep of the loop
// class Solution {
//     public int getSum(int a, int b) {
// 		int res = 0;
// 		int carry = 0;
// 		for (int i = 0; i < 32; i++) {
// 			int aBit = (a >> i) & 1; 
// 			int bBit = (b >> i) & 1; 
// 			int resultBit = 0;
//
// 			if (aBit == 0 && bBit == 0) {
// 				resultBit = carry;
// 				carry = 0;
// 			} else if (aBit == 1 && bBit == 1) {
// 				resultBit = carry;
// 				carry = 1;
// 			} else {
// 				resultBit = (aBit | bBit) ^ carry;
// 			}
//
//			res |= (resultBit << i);
// 		}
// 		return res;
// 	}
// }

// if not both of the bits are 1, then you OR them
// Which means if one of them is 1 then it becomes 1 if both are zero it stays zero
// Else (both are 1) you set that bit to zero and you carry the one to the next position

