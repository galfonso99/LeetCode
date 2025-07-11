// Original Solution kinda hack-y negative exponent handling but beautiful in its own way
class Solution {
	public double myPow(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
        if (n < 0) {
            if (n % 2 == 0) return myPow(1/x * 1/x, n / -2);
            else return 1/x * myPow(1/x, (n * -1) - 1);
        }

		if (n % 2 == 0) return myPow(x * x, n/2);
            
        return x * myPow(x*x, (n-1)/2);
	}
}

// Different Solution that circumvents the issue of integer overflow by simply casting
// n to a long
// class Solution {
// 	public double myPow(double x, int n) {
//         long N = n;
//         if (N < 0) {
//             x = 1/x;
//             N = -N;
//         }
// 		if (N == 0) return 1;
// 		if (N == 1) return x;
//
// 		if (N % 2 == 0) return myPow(x * x, (int) (N/2));
//
//         return x * myPow(x*x, (int) ((N-1)/2));
// 	}
// }
