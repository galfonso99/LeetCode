package main

import "core:fmt"

main :: proc() {
	grid := [][]int{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}
	count := max_area_of_island(grid)
	fmt.println(count)
}

max_area_of_island :: proc(grid: [][]int) -> int {
	max_area := 0
	for y in 0..<len(grid) {
		for x in 0..<len(grid[y]) {
			area := 0
			dfs(grid, y, x, &area)
			if area > max_area { 
				max_area = area 
			}
		}
	}
	return max_area
}

dirs :: [4][2]int{{-1,0},{0, 1},{1,0},{0, -1}}

dfs :: proc(grid: [][]int, y, x: int, area: ^int) {
	if y < 0 || y >= len(grid) || x < 0 || x >= len(grid[0]) {
		return 
	}
	if grid[y][x] == 0 do return

	grid[y][x] = 0
	area^ += 1

	for dir in dirs {
		dfs(grid, y + dir[0], x + dir[1], area)
	}
}

