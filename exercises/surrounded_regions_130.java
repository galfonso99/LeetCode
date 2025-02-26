// Optimized solution (Beats 86%)
class Solution {
	 public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
				if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1
												&& board[i][j] == 'O' && !visited[i][j]) {
                        dfs(board, visited, i, j);
                }
            }
        }  
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
        return;
	}

	private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] != 'O') {
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i-1, j);
        dfs(board, visited, i+1, j);
        dfs(board, visited, i, j-1);
        dfs(board, visited, i, j+1);
    }
}

// Original Working Solution ( O(2n) )
//class Solution {
//    public void solve(char[][] board) {
//		boolean[][] visited = new boolean[board.length][board[0].length];
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] == 'O') {
//					boolean reachesTheEdge = dfs(i, j, board, visited);
//					if (!reachesTheEdge) {
//						dfs2(i, j, board);
//					}
//				}
//			}
//		}
//    }
//	static int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
//	boolean dfs(int y, int x, char[][] board, boolean[][] visited) {
//		if (y == 0 || y == board.length - 1 || x == 0 || x == board[0].length - 1) {
//			return true;
//		}
//		visited[y][x] = true;
//		var onEdge = false;
//		for (var dir : DIRS) {
//			var dy = y + dir[0];
//			var dx = x + dir[1];
//			if (dy < 0 || dy >= board.length || dx < 0 || dx >= board[0].length 
//									|| visited[dy][dx] || board[dy][dx] != 'O') {
//				continue;
//			}
//			onEdge = onEdge || dfs(dy, dx, board, visited);
//		}
//		return onEdge;
//	}
//
//	void dfs2(int y, int x, char[][] board) {
//		board[y][x] = 'X';
//		for (var dir : DIRS) {
//			var dy = y + dir[0];
//			var dx = x + dir[1];
//			if (dy < 0 || dy >= board.length || dx < 0 || dx >= board[0].length 
//														|| board[dy][dx] != 'O') {
//				continue;
//			}
//			dfs2(dy, dx, board);
//		}
//	}
//}
