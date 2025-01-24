package main

import "core:fmt"
import "core:testing"

main :: proc() {
	array := [][]u8{{'0', '1', '1', '0'}, {'0', '0', '1', '1'}, {'0', '0', '0', '0'}, {'1', '1', '1', '1'}}
	count := num_islands(array)
	fmt.println(count)
}

num_islands :: proc(grid: [][]u8) -> int {
	nr_of_islands := 0
	for y in 0..<len(grid) {
		for x in 0..<len(grid[0]) {
			if grid[y][x] == '0' do continue
			// call dfs
			dfs(grid, y, x)
			nr_of_islands += 1
		}
	}
	return nr_of_islands
}

dirs :: [4][2]int{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}

dfs :: proc(grid: [][]u8, i, j: int) {
	if i < 0 || i >= len(grid) || j < 0 || j >= len(grid[0]) do return
	if grid[i][j] == '0' do return

	grid[i][j] = '0'
	for dir in dirs {
		dfs(grid, i + dir[0], j + dir[1])
	}
}

@(test)
test1 :: proc(t: ^testing.T) {
	grid := [][]u8{
    {'1', '1', '1', '1'},
    {'0', '0', '0', '1'},
    {'1', '1', '0', '1'},
    {'1', '0', '1', '1'}
	}
	nr := 2
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test2 :: proc(t: ^testing.T) {
	grid := [][]u8{
		{'1', '1', '1'},
		{'1', '1', '1'},
		{'1', '1', '1'},
	}
	nr := 1
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test3 :: proc(t: ^testing.T) {
	grid := [][]u8{
		{'0', '0', '0'},
		{'0', '0', '0'},
		{'0', '0', '0'},
	}
	nr := 0
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test4 :: proc(t: ^testing.T) {
	grid := [][]u8{
    {'0', '0', '0'},
    {'0', '1', '0'},
    {'0', '0', '0'},
}
	nr := 1
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test5 :: proc(t: ^testing.T) {
	grid := [][]u8{
    {'1', '0', '1', '1', '0', '1'},
    {'1', '0', '0', '0', '0', '0'},
    {'1', '0', '1', '1', '0', '1'},
}
	nr := 5
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test6 :: proc(t: ^testing.T) {
	grid := [][]u8{
    {'1', '0', '1'},
    {'0', '1', '0'},
    {'1', '0', '1'},
}
	nr := 5
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test7 :: proc(t: ^testing.T) {
	grid := [][]u8{
    {'1', '0', '0', '0', '0'},
    {'0', '0', '0', '0', '1'},
    {'0', '0', '0', '1', '1'},
    {'0', '0', '0', '0', '0'},
}
	nr := 2
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test8 :: proc(t: ^testing.T) {
	grid := [][]u8{}
	nr := 0
    testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test9 :: proc(t: ^testing.T) {
   grid := [][]u8{{'1', '1', '0', '1'}}
   nr := 2
   testing.expect_value(t, num_islands(grid), nr)
}
@(test)
test10 :: proc(t: ^testing.T) {
   grid := [][]u8{
       {'1'},
       {'0'},
       {'1'},
       {'1'},
   }
   nr := 2
   testing.expect_value(t, num_islands(grid), nr)
}
