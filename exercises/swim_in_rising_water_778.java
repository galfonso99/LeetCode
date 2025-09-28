import java.util.PriorityQueue;

// Fastest solution (More complex) using binary search
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = Math.max(grid[0][0], grid[n-1][n-1]);
        int right = n * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReach(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canReach(int[][] grid, int maxHeight) {
        int n = grid.length;
        if (grid[0][0] > maxHeight) return false;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        return dfs(grid, 0, 0, maxHeight, visited, dirs);
    }
    
    private boolean dfs(int[][] grid, int r, int c, int maxHeight, boolean[][] visited, int[][] dirs) {
        int n = grid.length;
        if (r == n-1 && c == n-1) return true;
        visited[r][c] = true;
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && 
                !visited[nr][nc] && grid[nr][nc] <= maxHeight) {
                if (dfs(grid, nr, nc, maxHeight, visited, dirs)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Original working solution
// class Solution {
//     public int swimInWater(int[][] grid) {
// 		int bottom = grid.length - 1;
// 		int right = grid[0].length - 1;
// 		boolean[][] visited = new boolean[grid.length][grid[0].length];
// 		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
// 		int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
// 		int[] curr = new int[] {grid[0][0], 0, 0};
//         visited[0][0] = true;
// 		int max_height = grid[0][0];
// 		while (curr[1] != bottom || curr[2] != right) {
// 			for (int[] dir : DIRS) {
// 				int y = curr[1] + dir[0], x = curr[2] + dir[1];
// 				if (y < 0 || y > bottom || x < 0 || x > right || visited[y][x]) continue;
// 				minHeap.offer(new int[] {grid[y][x], y, x});
// 				visited[y][x] = true;
// 			}
// 			curr = minHeap.poll();
// 			max_height = Math.max(curr[0], max_height);
// 		}
// 		return max_height;
//     }
// } 

// Optimized from the original
// class Solution {
//     public int swimInWater(int[][] grid) {
//         int n = grid.length;
//         boolean[][] visited = new boolean[n][n];
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
//         int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
//         pq.offer(new int[]{grid[0][0], 0, 0});
//         visited[0][0] = true;
//
//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int maxSoFar = curr[0], r = curr[1], c = curr[2];
//
//             if (r == n-1 && c == n-1) return maxSoFar;
//
//             for (int[] dir : dirs) {
//                 int nr = r + dir[0], nc = c + dir[1];
//                 if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
//                     visited[nr][nc] = true;
//                     pq.offer(new int[]{Math.max(maxSoFar, grid[nr][nc]), nr, nc});
//                 }
//             }
//         }
//         return -1;
//     }
// }

// Create a priority queue where you store 'visited' squares and their value
// visited array to avoid repeats
// you choose the next square based on the top value of the priority queue
// keep the max value visited stored in a variable and return it at the end
