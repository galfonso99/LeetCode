function longestPalindrome(s: string): string {
    let resIdx: number = 0;
    let resLen: number = 0;
    const n: number = s.length;
    
    // Create 2D array and initialize with false
    const dp: boolean[][] = Array(n).fill(0).map(() => Array(n).fill(false));
    
    for (let i = n - 1; i >= 0; i--) {
        for (let j = i; j < n; j++) {
            if (s.charAt(i) === s.charAt(j) && 
                (j - i <= 2 || dp[i + 1][j - 1])) {
                
                dp[i][j] = true;
                if (resLen < (j - i + 1)) {
                    resIdx = i;
                    resLen = j - i + 1;
                }
            }
        }
    }
    
    return s.substring(resIdx, resIdx + resLen);
}
