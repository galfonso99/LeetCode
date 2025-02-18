// Basically do a bfs and add each treasure chest to the starting state of the queue
// That way the queue will alternate between each treasure chest location ensuring that 
// each distance is the closest to a chest
// If out of bounds or non infinity skip that one
function islandsAndTreasure(grid: number[][]): void {
	const queue: [number, number][] = [];
	const m = grid.length;
	const n = grid[0].length;
	const max_int = 2147483647;


	// Find starting positions
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (grid[i][j] === 0) {
				queue.push([i, j]);
			}
		}
	}

	if (!queue.length) return;

	const dirs: [number, number][] = [[-1, 0], [0, -1], [1, 0], [0, 1]];

	while (queue.length) {
		const [row, col] = queue.shift()!;

		for (const [dx, dy] of dirs) {
			const r = row + dx;
			const c = col + dy;

			if (r >= m || c >= n || r < 0 || c < 0 || 
				grid[r][c] !== max_int) {
				continue;
			}

			queue.push([r, c]);
			grid[r][c] = grid[row][col] + 1;
		}
	}
}
