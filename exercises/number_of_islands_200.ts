const DIRS: number[][] = [[-1, 0], [0, 1], [1, 0], [0, -1]];

function numIslands(grid: string[][]): number {
    let nrOfIslands = 0;
    
    for (let y = 0; y < grid.length; y++) {
        for (let x = 0; x < grid[0].length; x++) {
            if (grid[y][x] === '0') continue;
            dfs(grid, y, x);
            nrOfIslands++;
        }
    }
    
    return nrOfIslands;
}

function dfs(grid: string[][], i: number, j: number): void {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
    if (grid[i][j] === '0') return;
    
    grid[i][j] = '0';
    for (const dir of DIRS) {
        dfs(grid, i + dir[0], j + dir[1]);
    }
}

const array = [
    ['0', '1', '1', '0'],
    ['0', '0', '1', '1'],
    ['0', '0', '0', '0'],
    ['1', '1', '1', '1']
];
console.log(numIslands(array));
