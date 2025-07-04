// Better solution respecting the starting negative/positive sign
class Solution {
    public int reverse(int x) {
        final int MIN = -2147483648; // -2^31
        final int MAX = 2147483647;  // 2^31 - 1
        int res = 0;
        while (x != 0) {
            int digit = x % 10;
            if (res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10)) return 0;
            if (res < MIN / 10 || (res == MIN / 10 && digit < MIN % 10)) return 0;
            res = (res * 10) + digit;
            x /= 10;
        }
        return res;
    }
}

// Original Solution
// class Solution {
//     public int reverse(int x) {
// 		int res = 0;
// 		boolean neg = false;
// 		if (x < 0) {
//             neg = true;
//             x *= -1;
//         }
// 		while (x > 0) {
// 			if (multWillOverflow(res, 10)) return 0;
//             res *= 10;
//             int digit = x % 10;
// 			res += digit;
// 			x /= 10;
// 		}
// 		return neg ? res * -1 : res;
//
//     }
//
//     boolean multWillOverflow(int x, int y) {
//         try {
//             Math.multiplyExact(x, y);
//             return false;
//         } catch (ArithmeticException e) {
//             return true;
//         }
//     }
// }

// So basically you can shave digit by digit from the right to left from the original
// integer
// Then take those digits and add it to a new integer from left to right
