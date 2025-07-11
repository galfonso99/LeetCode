import java.util.Arrays;

// Optimal Solution (By knowing the index of the resulting digit you can add to that
// index and its carry by doing +1
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i1 = 0; i1 < num1.length(); i1++) {
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int digit = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                res[i1 + i2] += digit;
                res[i1 + i2 + 1] += res[i1 + i2] / 10;
                res[i1 + i2] %= 10;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            result.append(res[i--]);
        }
        return result.toString();
    }
}

// First passing Solution (ugly, disgusting)
// class Solution {
// 	public String multiply(String num1, String num2) {
// 		// Switch places if num2 is bigger
// 		if (num2.length() > num1.length()) {
// 			var tmp = num1;
// 			num1 = num2;
// 			num2 = tmp;
// 		}
//         int n = num1.length();
//         int m = num2.length();
//         if (m == 1 && num2.charAt(0) == '0') return "0";
//         int[] res = new int[n + m + 1];
//         int[] scratch = new int[n+1];
// 		for (int i = num2.length() - 1; i >= 0; i--) {
// 			int digit2 = num2.charAt(i) - '0';
//             int carry = 0;
//             int j;
// 			for (j = num1.length() - 1; j >= 0; j--) {
// 				int digit1 = num1.charAt(j) - '0';
// 				int product = digit1 * digit2;
//                 int value = product + carry;
//                 int resDigit = value % 10;
//                 carry = value / 10;
// 				scratch[j + 1] = resDigit;
// 			}
//             scratch[j + 1] = carry;
//             carry = 0;
//             for (j = 0; j < scratch.length; j++) {
//                 int scratchPos = scratch.length - 1 - j;
//                 int resultPos = res.length - 1 - j - (num2.length() - 1 - i);
//                 int value = scratch[scratchPos] + res[resultPos] + carry;
//                 int resDigit = value % 10;
//                 carry = value / 10;
//                 res[resultPos] = resDigit;
//             }
//             res[res.length - 1 - j - (num2.length() - 1 - i)] = carry;
//             Arrays.fill(scratch, 0);
// 		}
//         String resString = "";
//         int i = 0;
//         while (i < 2 && res[i] == 0) i++;
//         while (i < res.length) {
//             resString += (char) (res[i] + '0');
//             i++;
//         }
// 		return resString;
// 	}
// }
