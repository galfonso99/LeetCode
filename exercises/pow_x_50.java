class Solution {
    public double myPow(double x, long n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return rec(x, n);
    }
    double rec(double x, long n) {
        if (n == 0)
            return 1;
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

// Iterative solution using bits
//class Solution {
//	public double myPow(double x, int n) {
//		if(n < 0){
//			n = -n;
//			x = 1 / x;
//		}
//		double pow = 1;
//		while(n != 0){
//			if((n & 1) != 0){
//				pow *= x;
//			} 
//			x *= x;
//			n >>>= 1;
//		}
//		return pow;
//	}
//}
