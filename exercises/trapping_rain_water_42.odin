package main

import "core:fmt"

main :: proc() {
	array := []int{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}
	count := trap(array)
	fmt.println(count)
}

trap :: proc(arr: []int) -> int {
	l, r := 0, len(arr) - 1
	l_highest, r_highest := 0, 0
	total := 0

	for l < r {
		if arr[l] <= arr[r] {
			if arr[l] >= l_highest {
				l_highest = arr[l]
			} else {
				total += l_highest - arr[l]
			}
			l += 1
		} else {
			if arr[r] >= r_highest {
				r_highest = arr[r]
			} else {
				total += r_highest - arr[r]
			}
			r -= 1
		}
	}
	return total
}
