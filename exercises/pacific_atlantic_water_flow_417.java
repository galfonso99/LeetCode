import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

// DFS Solution much faster ( try to remember that for graph problems the optimal solution
// might be BFS OR DFS, either one)
class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, 
                                  {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length && 
                nc >= 0 && nc < heights[0].length && 
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}

// BFS Solution (slow)
//class Solution {
//    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//        int ROWS = heights.length, COLS = heights[0].length;
//        boolean[][] pac = new boolean[ROWS][COLS];
//        boolean[][] atl = new boolean[ROWS][COLS];
//
//        Queue<int[]> pacQueue = new LinkedList<>();
//        Queue<int[]> atlQueue = new LinkedList<>();
//
//        for (int c = 0; c < COLS; c++) {
//            pacQueue.add(new int[]{0, c});
//            atlQueue.add(new int[]{ROWS - 1, c});
//        }
//        for (int r = 0; r < ROWS; r++) {
//            pacQueue.add(new int[]{r, 0});
//            atlQueue.add(new int[]{r, COLS - 1});
//        }
//
//        bfs(pacQueue, pac, heights);
//        bfs(atlQueue, atl, heights);
//
//        List<List<Integer>> res = new ArrayList<>();
//        for (int r = 0; r < ROWS; r++) {
//            for (int c = 0; c < COLS; c++) {
//                if (pac[r][c] && atl[r][c]) {
//                    res.add(Arrays.asList(r, c));
//                }
//            }
//        }
//        return res;
//    }
//
//    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            int r = cur[0], c = cur[1];
//            ocean[r][c] = true;
//            for (int[] d : directions) {
//                int nr = r + d[0], nc = c + d[1];
//                if (nr >= 0 && nr < heights.length && nc >= 0 && 
//                    nc < heights[0].length && !ocean[nr][nc] && 
//                    heights[nr][nc] >= heights[r][c]) {
//                    q.add(new int[]{nr, nc});
//                }
//            }
//        }
//    }
//}

// Clever solution (only for recreational use not for coding interview)
//class Solution {
//    static void dfs(int i, int j, int w, int h, int[][] M, byte[] dp, List<List<Integer>> ans) {
//        int ij = i * M[0].length + j;
//        if ((dp[ij] & w) > 0 || M[i][j] < h) return;
//        dp[ij] += w;
//        h = M[i][j];
//        if (dp[ij] == 3) ans.add(Arrays.asList(i,j)); 
//        if (i + 1 < M.length) dfs(i+1, j,w,h,M,dp,ans);
//        if (i > 0) dfs(i-1,j,w,h,M,dp,ans);
//        if (j + 1 < M[0].length) dfs(i, j+1, w,h,M, dp, ans);
//        if (j > 0) dfs(i, j-1, w,h,M,dp,ans); 
//    }
//
//    public List<List<Integer>> pacificAtlantic(int[][] M) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if (M.length == 0) return ans;
//        int y = M.length, x = M[0].length;
//        byte[] dp = new byte[x*y];
//        for (int i = 0; i < x; i++) {
//            dfs(0, i, 1, M[0][i], M, dp, ans);
//            dfs(y-1, i, 2, M[y-1][i], M, dp, ans); 
//        }
//
//        for (int i = 0; i < y; i++) {
//            dfs(i, 0, 1, M[i][0], M, dp, ans);
//            dfs(i, x-1,2, M[i][x-1], M, dp, ans); 
//        }
//
//        return ans; 
//    }
//}
