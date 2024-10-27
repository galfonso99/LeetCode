package main

import (
    "unicode"
)
func validPalindrome(s string) bool {
    str := filterString([]byte(s))
    head := 0
    tail := len(str) - 1
    isPalindrome := true
    for head < tail {
        if unicode.ToUpper(rune(str[head])) != unicode.ToUpper(rune(str[tail])) {
            isPalindrome = false
            break
        }
        head += 1
        tail -= 1
    }
    return isPalindrome
}

func isAlphanumeric (c byte) bool {
    // return unicode.IsDigit(c) || unicode.IsLetter(c)
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' ||
             c >= '0' && c <= '9'
}

func filterString(str []byte) (ret []byte) {
    for _, s := range str {
        if isAlphanumeric(s) {
            ret = append(ret, s)
        }
    }
    return
}
