// Once n becomes single digit it is only a happy number if it is 1 or 7
// Otherwise it cant become a happy number
class Solution {
    public boolean isHappy(int n) {
        while (n > 9) {  // n > 9
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }            
            n = sum;
        }        
        return n == 1 || n == 7; // from 1 to 9 lucky numbers are 1 and 7
    }
}

// Tortoise and Hare Floyd's Cycle Finding Algorithm
//class Solution {
//    public boolean isHappy(int n) {
//        int slow = n;
//        int fast = n;
//        do {
//            slow = square(slow);
//            fast = square(square(fast));
//        } while (slow != fast);
//        return slow == 1;
//    }
//    public int square(int num) {
//        int ans = 0;
//        while(num > 0) {
//            int remainder = num % 10;
//            ans += remainder * remainder;
//            num /= 10;
//        }
//        return ans;
//    }
//}

// Using a seen Hashmap solution
//class Solution {
//    public boolean isHappy(int n) {
//        Set<Integer> seen = new HashSet<>();
//        while (n != 1 && !seen.contains(n)) {
//            seen.add(n);
//            int sum = 0;
//            while (n != 0) {
//                int digit = n % 10;
//                sum += digit * digit;
//                n /= 10;
//            }
//            n = sum;
//        }
//        return n == 1;
//    }
//}

// Brute-force solution
//class Solution {
//    public boolean isHappy(int n) {
//        int i = 0;
//		while (i < 20) {
//            int sum = 0;
//			while (n > 9) {
//				int mod = n % 10;
//				sum += (int) Math.pow((double) mod, 2.0);
//				n /= 10;
//			}
//            sum += (int) Math.pow((double) n, 2.0);
//			if (sum == 1) {
//				return true;
//			}
//            n = sum;
//            i+=1;
//		}
//		return false;
//	}
//
//}
