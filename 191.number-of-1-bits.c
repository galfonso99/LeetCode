/*
 * @lc app=leetcode id=191 lang=c
 *
 * [191] Number of 1 Bits
 */
#include <stdint.h>

// @lc code=start
int hammingWeight(uint32_t n) {
    int counter = 0;
    for (int i = 0; i < 32; i++) {
        if (n & 1 == 1) {
            counter++;
        }
        n >>= 1;
    }
    return counter;
}
// @lc code=end

