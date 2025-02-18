function orangesRotting(grid: number[][]): number {
	const q: number[][] = [];
	let freshCount = 0;
	let rottenCount = 0;
	let count = 0;
	for (let i = 0; i < grid.length; i++) {
		for (let j = 0; j < grid[0].length; j++) {
			if (grid[i][j] == 2) {
				q.push([i, j])
			} else if (grid[i][j] == 1) {
				freshCount++
			}
		}
	}
	const DIRS = [[-1, 0], [0, 1], [1, 0], [0, -1]]
	while (q.length != 0) {
		const size = q.length
		for (let i = 0; i < size; i++) {
			const orange = q.shift()!
			for (const dir of DIRS) {
				const r = orange[0] + dir[0]
				const c = orange[1] + dir[1]

				if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || 
						grid[r][c] != 1) {
					continue
				}
				grid[r][c] = 2
				q.push([r, c])
				rottenCount++
			}
		}
		if (q.length != 0) count++
	}
	return freshCount == rottenCount ? count : -1
};

