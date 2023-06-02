/*
 * @lc app=leetcode id=202 lang=c
 *
 * [202] Happy Number
 */
#include <stdbool.h>
// @lc code=start
bool isHappy(int n)
{
    int repeat_value = 0;
    int count = 0;
    int counter = 0;
    while (n != 1)
    {
        while (n > 0)
        {
            
            int digit = n % 10;
            count += digit * digit;
            n /= 10;
        }
        if (count == repeat_value) {return false;}
        if (counter % 10 == 0) {
            repeat_value = count; 
        }
        n = count;
        count = 0;
        counter++;
        
    }
    return true;
}
// @lc code=end

// as you take a digit one by one using modulo and division by 10, square the digit you got and add it to the running sum. That sum eventually becomes the new number for the next iteration. Make sure you never become the first number a second time, meaning your in an endless loop

// Keep in mind that the loop might start somewhere in the middle and not necessarily at the initial value