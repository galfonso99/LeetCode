package main

// import "container/list"

func isValid(s string) bool {
    // l := list.New()
    var stack []byte
    for _, b := range []byte(s) {
        last := stack[len(stack) - 1]
        if last == '{' && b == '}' {
            stack = stack[:len(stack)-1]
        } else if last == '[' && b == ']' {
            stack = stack[:len(stack)-1]
        } else if last == '(' && b == ')' {
            stack = stack[:len(stack)-1]
        } else {
            stack = append(stack, b)
        }
    }
    return len(stack) == 0
}
