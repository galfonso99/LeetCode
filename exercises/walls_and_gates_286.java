// Loop through every spot on the grid and for each that is infinity
// we will bfs traverse the grid from that spot until we reach a treasure and
// return how many steps to get there
// Then replace that infinity number with the return amount of steps
// MAKE sure to skip spots that are not infinity

import java.util.LinkedList;
import java.util.Queue;

// Most optimal solution using multiple sources aka alternating between treasure sources
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        if (q.size() == 0) return;

        int[][] dirs = { { -1, 0 }, { 0, -1 }, 
                         { 1, 0 }, { 0, 1 } };
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= m || c >= n || r < 0 ||
                    c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                q.add(new int[] { r, c });

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
// Original working Solution
//class Solution {
//	int[][] DIRS = new int[][]{{0, -1},{1, 0},{0, 1},{-1, 0}};
//    public void islandsAndTreasure(int[][] grid) {
//		int MAX = Integer.MAX_VALUE;
//		for (var y = 0; y < grid.length; y++) {
//			for (var x = 0; x < grid[0].length; x++) {
//				if (grid[y][x] == MAX) {
//					bfs(grid, new boolean[grid.length][grid[0].length], x, y);
//				}
//			}
//		}
//    }
//
//	void bfs(int[][] grid, boolean[][] seen, int x, int y) {
//		Queue<Point> queue = new LinkedList<Point>();
//		var found = false;
//		queue.add(new Point(x, y));
//		var steps = 0;
//
//		while (queue.size() > 0 && !found) {
//			var length = queue.size();
//			steps++;
//			outer: for (var i = 0; i < length; i++) {
//				var p = queue.poll();
//				seen[p.y][p.x] = true;
//
//				for (var dir : DIRS) {
//					var new_x = p.x + dir[0];
//					var new_y = p.y + dir[1];
//					if (new_y < 0 || new_y >= grid.length || new_x < 0 || new_x >= grid[0].length) {
//						continue;
//					}
//					var new_val = grid[new_y][new_x];
//					if (new_val == -1 || seen[new_y][new_x]) {
//						continue;
//					}
//					if (new_val == 0) {
//						found = true;
//						break outer;
//					}
//					queue.add(new Point(new_x, new_y));
//				}
//			}
//		}
//		grid[y][x] = steps;
//	}
//}
//
//class Point {
//	int x;
//	int y;
//	Point(int x, int y) {this.x = x; this.y = y;};
//}


