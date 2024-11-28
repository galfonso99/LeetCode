import java.util.List;
import java.util.ArrayList;

// Even more Optimized solution without seen array by setting the char to '#'
class Solution {
   private int[][] dirs = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
   private char[][] board;
   
   public boolean exist(char[][] board, String word) {
       this.board = board;
       
       int[] charCount = new int[128];
       List<int[]> start_coords = new ArrayList<>();
       
       for (int y = 0; y < board.length; y++) {
           for (int x = 0; x < board[0].length; x++) {
               charCount[board[y][x]]++;
               if (board[y][x] == word.charAt(0)) {
                   start_coords.add(new int[] {x, y});
               }
           }
       }
       
       for (char c : word.toCharArray()) {
           charCount[c]--;
           if (charCount[c] < 0) return false;
       }
       
       if (start_coords.isEmpty()) return false;
       
       return start_coords.stream().anyMatch(coord -> 
           walk(word, coord[0], coord[1], 0));
   }
   
   private boolean walk(String word, int x, int y, int idx) {
       if (idx == word.length()) return true;
       if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) return false;
       if (board[y][x] != word.charAt(idx)) return false;
       
       char temp = board[y][x];
       board[y][x] = '#';
       
       for (int[] dir : dirs) {
           if (walk(word, x + dir[0], y + dir[1], idx + 1)) {
               board[y][x] = temp;
               return true;
           }
       }
       
       board[y][x] = temp;
       return false;
   }
}
// With search Pruning Optimization
//class Solution {
//	int[][] coords = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
//    public boolean exist(char[][] board, String word) {
//		int height = board.length;
//		int width = board[0].length;
//        int[] char_count = new int[67];
//		boolean[][] seen = new boolean[board.length][board[0].length];
//		List<Character> path = new ArrayList<Character>();
//		// Get a count for each char in the board
//        for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//                char_count[board[i][j] - 'A'] += 1;
//            }
//        }
//		// Remove char count for each char in the seach word
//		// If goes negative return false
//        for (var ch : word.toCharArray()) {
//            char_count[ch - 'A'] -= 1;
//            if (char_count[ch - 'A'] < 0) return false;
//        }
//		// Start search for each char that is equal to the first char
//		// of the seach word
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (board[i][j] != word.charAt(0)) continue;
//                if ( walk(board, word, seen, path, j, i) ) {
//                    return true;
//                }
//                path.clear();
//                seen = new boolean[height][width];
//			}
//		}
//		return false;
//    }
//	private boolean walk(char[][] board, String word, boolean[][] seen, 
//		List<Character> path, int x , int y) {
//		if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) return false;
//		if (seen[y][x]) return false;
//		if (board[y][x] != word.charAt(path.size())) return false;
//        if (path.size() == word.length() - 1) return true;
//
//		seen[y][x] = true;
//        path.add(board[y][x]);
//		for (var coord : coords) {
//			if ( walk(board, word, seen, path, x + coord[0], y + coord[1]) ) {
//				return true;
//			}
//		}
//        path.remove(path.size() -1);
//        seen[y][x] = false;
//		return false;
//	}
//}

// Original Solution without optimization
//class Solution {
//	int[][] coords = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
//    public boolean exist(char[][] board, String word) {
//		int height = board.length;
//		int width = board[0].length;
//		boolean[][] seen = new boolean[board.length][board[0].length];
//		List<Character> path = new ArrayList<Character>();
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//                boolean found = false;
//				if (board[i][j] != word.charAt(0)) continue;
//                if ( walk(board, word, seen, path, j, i) ) {
//                    return true;
//                }
//                path.clear();
//                seen = new boolean[height][width];
//			}
//		}
//		return false;
//    }
//	private boolean walk(char[][] board, String word, boolean[][] seen, 
//		List<Character> path, int x , int y) {
//		if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) return false;
//		if (seen[y][x]) return false;
//		if (board[y][x] != word.charAt(path.size())) return false;
//        if (path.size() == word.length() - 1) return true;
//
//		seen[y][x] = true;
//        path.add(board[y][x]);
//		for (var coord : coords) {
//			if ( walk(board, word, seen, path, x + coord[0], y + coord[1]) ) {
//				return true;
//			}
//		}
//        path.remove(path.size() -1);
//        seen[y][x] = false;
//		return false;
//	}
//}

