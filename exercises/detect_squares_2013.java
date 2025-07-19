import java.util.HashMap;
import java.util.Map;

// Optimal Solution using a 2 dimensional HashMap instead
class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> ptsCount;

    public DetectSquares() {
        ptsCount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        ptsCount.putIfAbsent(x, new HashMap<>());
        ptsCount.get(x).put(y, ptsCount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0, x1 = point[0], y1 = point[1];

        if (!ptsCount.containsKey(x1)) return res;

        for (int y2 : ptsCount.get(x1).keySet()) {
            int side = y2 - y1;
            if (side == 0) continue;

            int x3 = x1 + side, x4 = x1 - side;
            res += ptsCount.get(x1).get(y2) *
                   ptsCount.getOrDefault(x3, new HashMap<>()).getOrDefault(y1, 0) *
                   ptsCount.getOrDefault(x3, new HashMap<>()).getOrDefault(y2, 0);

            res += ptsCount.get(x1).get(y2) *
                   ptsCount.getOrDefault(x4, new HashMap<>()).getOrDefault(y1, 0) *
                   ptsCount.getOrDefault(x4, new HashMap<>()).getOrDefault(y2, 0);
        }

        return res;
    }
}
// Original working solution
// class DetectSquares {
// 	int[][] coords;
// 	int maxX;
// 	int maxY;
// 	int[][] DIRS = new int[][]{{1,1}, {1,-1}, {-1,-1}, {-1,1}};
//     public DetectSquares() {
// 		coords = new int[1001][1001];
//     }
//
//     public void add(int[] point) {
// 		coords[point[0]][point[1]] += 1;
// 		maxX = Math.max(point[0], maxX);
// 		maxY = Math.max(point[1], maxY);
//     }
//
//     public int count(int[] point) {
// 		int total_count = 0;
//
// 		for (int[] dir : DIRS) {
// 			int dx = dir[0];
// 			int dy = dir[1];
//             for (int x = point[0] + dx, y = point[1] + dy; 
//                 x >= 0 && x <= maxX && y >= 0 && y <= maxY; 
//                 x += dx, y += dy)
//             {
// 				if (coords[x][y] == 0) continue;
// 				if (coords[point[0]][y] > 0 && coords[x][point[1]] > 0) {
// 					total_count += coords[x][y] * coords[point[0]][y] * coords[x][point[1]];
// 				}
// 			}
// 		}
// 		return total_count;
//     }
// }

// Slightly better, easier to read code improvement from the optimal solution
// class CountSquares {
//     private Map<Integer, Map<Integer, Integer>> ptsCount;
//
//     public CountSquares() {
//         ptsCount = new HashMap<>();
//     }
//
//     public void add(int[] point) {
//         int x = point[0], y = point[1];
//         ptsCount.putIfAbsent(x, new HashMap<>());
//         ptsCount.get(x).put(y, get2D(ptsCount, x, y) + 1);
//     }
//
//     public int count(int[] point) {
//         int res = 0, x1 = point[0], y1 = point[1];
//
//         if (!ptsCount.containsKey(x1)) return res;
//
//         for (int y2 : ptsCount.get(x1).keySet()) {
//             int side = y2 - y1;
//             if (side == 0) continue;
//
//             int x3 = x1 + side, x4 = x1 - side;
//             res += get2D(ptsCount, x1, y2) *
//                    get2D(ptsCount, x3, y1) *
//                    get2D(ptsCount, x3, y2);
//
//             res += get2D(ptsCount, x1, y2) *
//                    get2D(ptsCount, x4, y1) *
//                    get2D(ptsCount, x4, y2);
//         }
//
//         return res;
//     }
//
//     public int get2D(Map<Integer, Map<Integer, Integer>> map, int x, int y) {
//         return map.getOrDefault(x, new HashMap<>()).getOrDefault(y, 0);
//     }
// }

