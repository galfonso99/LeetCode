function solve(board: string[][]): void {
    if (board.length === 0 || board[0].length === 0) return;
    
    const m = board.length;
    const n = board[0].length;
    const visited: boolean[][] = Array(m).fill(0).map(() => Array(n).fill(false));
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if ((i === 0 || j === 0 || i === m - 1 || j === n - 1) && 
                board[i][j] === 'O' && !visited[i][j]) {
                dfs(board, visited, i, j);
            }
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 'O' && !visited[i][j]) {
                board[i][j] = 'X';
            }
        }
    }
}

function dfs(board: string[][], visited: boolean[][], i: number, j: number): void {
    const m = board.length;
    const n = board[0].length;
    
    if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] !== 'O') {
        return;
    }
    
    visited[i][j] = true;
    
    dfs(board, visited, i-1, j);
    dfs(board, visited, i+1, j);
    dfs(board, visited, i, j-1);
    dfs(board, visited, i, j+1);
}
