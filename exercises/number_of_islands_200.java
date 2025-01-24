class Solution {
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        int nrOfIslands = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '0') continue;
                dfs(grid, y, x);
                nrOfIslands++;
            }
        }
        return nrOfIslands;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] array = {
            {'0', '1', '1', '0'},
            {'0', '0', '1', '1'},
            {'0', '0', '0', '0'},
            {'1', '1', '1', '1'}
        };
        int count = solution.numIslands(array);
        System.out.println(count);
    }
}
