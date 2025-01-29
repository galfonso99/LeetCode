package main

import "core:fmt"

main :: proc() {
	array := []int{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}
	count := largest_rectangle(array)
	fmt.println(count)
}

largest_rectangle :: proc(heights: []int) -> int {
	n := len(heights)	
	max_area := 0
	stack := make([dynamic]int)
	defer delete(stack)

	for i in 0..=n {
		for len(stack) > 0 && (i == n || heights[stack[len(stack)-1]] >= heights[i]) {
			h := heights[stack[len(stack) - 1]]
			pop(&stack)
			w := len(stack) == 0 ? i : i - stack[len(stack) - 1] - 1
			max_area = max(max_area, h * w)
		}
		append(&stack, i)
	}
	return max_area
} 
