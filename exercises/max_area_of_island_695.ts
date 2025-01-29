const DIRECTIONS: [number, number][] = [[-1, 0], [0, 1], [1, 0], [0, -1]];

function maxAreaOfIsland(grid: number[][]): number {
    if (!grid.length) return 0;

    const rows = grid.length;
    const cols = grid[0].length;
    let maxArea = 0;

    for (let y = 0; y < rows; y++) {
        for (let x = 0; x < cols; x++) {
            if (grid[y][x] == 0) {continue}
            maxArea = Math.max(maxArea, dfs(grid, y, x));
        }
    }

    return maxArea;
}
    
function dfs(grid: number[][], y: number, x: number): number {
    if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
        return 0;
    }

    if (grid[y][x] === 0) return 0;

    grid[y][x] = 0;
    let area = 1;

    for (const [dy, dx] of DIRECTIONS) {
        area += dfs(grid, y + dy, x + dx);
    }

    return area;
}

// Iterative Solution really fast
//const DIRECTIONS = [-1, 0, 1, 0, -1];
//
//function maxAreaOfIsland(grid: number[][]): number {
//    const rows = grid.length;
//    const cols = grid[0].length;
//    let maxArea = 0;
//    let stack: number[] = new Array(rows * cols * 2);
//    let stackPtr = 0;
//
//    for (let y = 0; y < rows; y++) {
//        for (let x = 0; x < cols; x++) {
//            if (grid[y][x] === 0) continue;
//
//            let area = 0;
//            stackPtr = 0;
//            stack[stackPtr++] = y;
//            stack[stackPtr++] = x;
//
//            while (stackPtr > 0) {
//                const cx = stack[--stackPtr];
//                const cy = stack[--stackPtr];
//
//                if (cy < 0 || cy >= rows || cx < 0 || cx >= cols || grid[cy][cx] === 0) {
//                    continue;
//                }
//
//                grid[cy][cx] = 0;
//                area++;
//
//                for (let i = 0; i < 4; i++) {
//                    stack[stackPtr++] = cy + DIRECTIONS[i];
//                    stack[stackPtr++] = cx + DIRECTIONS[i + 1];
//                }
//            }
//
//            if (area > maxArea) maxArea = area;
//        }
//    }
//    return maxArea;
//}

