import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int orangesRotting(int[][] grid) {
		Queue<int[]> q = new LinkedList<int[]>();
        int freshCount = 0;
        int rottenCount = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[]{i, j});
				} else if (grid[i][j] == 1) {
                    freshCount++;
                }
        	}
        }
		int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		while (!q.isEmpty()) {
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var orange = q.poll();
                for (var dir : DIRS) {
                    var r = orange[0] + dir[0];
                    var c = orange[1] + dir[1];
                    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
                        continue;
                    }
                    q.add(new int[]{r, c});
                    grid[r][c] = 2;
                    rottenCount++;
                }
            }
            if (!q.isEmpty()) count++;
		}
		return freshCount == rottenCount ? count : -1;
    }
}

// Create a queue
// For each spoiled orange add it to the queue
// Then Process the oranges so than for each dequeued orange we process each neighbor
// orange in the four directions
