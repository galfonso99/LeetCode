const directions: number[][] = [[1, 0], [-1, 0], [0, 1], [0, -1]];

// Efficient DFS solution that beats 93%
function pacificAtlantic(heights: number[][]): number[][] {
    const ROWS = heights.length;
    const COLS = heights[0].length;
	const pac: boolean[][] = Array(ROWS).fill([]).map(() => Array(COLS).fill(false));
	const atl: boolean[][] = Array(ROWS).fill([]).map(() => Array(COLS).fill(false));

    for (let c = 0; c < COLS; c++) {
        dfs(0, c, pac, heights);
        dfs(ROWS - 1, c, atl, heights);
    }

    for (let r = 0; r < ROWS; r++) {
        dfs(r, 0, pac, heights);
        dfs(r, COLS - 1, atl, heights);
    }

    const res: number[][] = [];
    for (let r = 0; r < ROWS; r++) {
        for (let c = 0; c < COLS; c++) {
            if (pac[r][c] && atl[r][c]) {
                res.push([r, c]);
            }
        }
    }

    return res;
}

function dfs(r: number, c: number, ocean: boolean[][], heights: number[][]): void {
    ocean[r][c] = true;
    for (let d of directions) {
        const nr = r + d[0], nc = c + d[1];
        if (nr >= 0 && nr < heights.length && 
            nc >= 0 && nc < heights[0].length && 
            !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
            dfs(nr, nc, ocean, heights);
        }
    }
}

