// Recursive Solution
class Solution {
    private static final int[][] DIRECTIONS = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                maxArea = Math.max(maxArea, dfs(grid, y, x));
            }
        }
        return maxArea;
    }
    
    private int dfs(int[][] grid, int y, int x) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return 0;
        }
        if (grid[y][x] == 0) {
            return 0;
        }
        grid[y][x] = 0;
        int area = 1;
        for (int[] dir : DIRECTIONS) {
            area += dfs(grid, y + dir[0], x + dir[1]);
        }
        return area;
    }
}

// Fast Iterative Solution
//class Solution {
//    private static final int[] DIRECTIONS = {-1, 0, 1, 0, -1};
//
//    public int maxAreaOfIsland(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int maxArea = 0;
//        int[] stack = new int[rows * cols * 2];
//        int stackPtr = 0;
//
//        for (int y = 0; y < rows; y++) {
//            for (int x = 0; x < cols; x++) {
//                if (grid[y][x] == 0) continue;
//
//                int area = 0;
//                stackPtr = 0;
//                stack[stackPtr++] = y;
//                stack[stackPtr++] = x;
//
//                while (stackPtr > 0) {
//                    int cx = stack[--stackPtr];
//                    int cy = stack[--stackPtr];
//
//                    if (cy < 0 || cy >= rows || cx < 0 || cx >= cols || grid[cy][cx] == 0) {
//                        continue;
//                    }
//
//                    grid[cy][cx] = 0;
//                    area++;
//
//                    for (int i = 0; i < 4; i++) {
//                        stack[stackPtr++] = cy + DIRECTIONS[i];
//                        stack[stackPtr++] = cx + DIRECTIONS[i + 1];
//                    }
//                }
//
//                if (area > maxArea) maxArea = area;
//            }
//        }
//        return maxArea;
//    }
//}
