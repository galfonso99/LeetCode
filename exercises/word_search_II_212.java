import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Using Array instead of HashMap
class Trie {
	Trie[] children; // Array for 26 lowercase letters
	boolean isEndOfWord;
	String completeWord;
	boolean isFound;
	
	public Trie() { 
		children = new Trie[26]; 
	}
	
	public void insert(String word) {
		var current = this;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a'; // Convert to 0-25 index
			if (current.children[index] == null) {
				current.children[index] = new Trie();
			}
			current = current.children[index];
		}
		current.isEndOfWord = true;
		current.completeWord = word;
	}
}

class Solution {
	final int[][] DIRS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		for (String word : words) {
			root.insert(word);
		}
		List<String> res = new ArrayList<>();
		int rows = board.length;
		int cols = board[0].length;
		boolean[][] visited;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited = new boolean[rows][cols];
				walk(board, i, j, root, visited, res);
			}	
		}
		return res;
	}
	
	void walk(char[][] board, int row, int col, Trie currNode, boolean[][] visited, List<String> res) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
		if (visited[row][col]) return;
		
		char ch = board[row][col];
		int index = ch - 'a'; // Convert to 0-25 index
		if (currNode.children[index] == null) return;
		
		Trie nextNode = currNode.children[index];
		visited[row][col] = true;
		
		if (nextNode.isEndOfWord && !nextNode.isFound) {
			res.add(nextNode.completeWord);
			nextNode.isFound = true;
		}
		
		for (var dir : DIRS) {
			walk(board, row + dir[0], col + dir[1], nextNode, visited, res);
		}
		visited[row][col] = false;
	}
}

// Most optimized solution Beats 98% Leetcode
// class Trie {
// 	Trie[] children; 
// 	boolean isEndOfWord;
// 	String completeWord;
//
// 	public Trie() { children = new Trie[26]; }
//
// 	public void insert(String word) {
// 		var current = this;
// 		for (int i = 0; i < word.length(); i++) {
// 			char ch = word.charAt(i);
// 			int index = ch - 'a'; 
// 			if (current.children[index] == null) {
// 				current.children[index] = new Trie();
// 			}
// 			current = current.children[index];
// 		}
// 		current.isEndOfWord = true;
// 		current.completeWord = word;
// 	}
//
// 	public boolean isEmpty() {
// 		for (Trie child : children) {
// 			if (child != null) return false;
// 		}
// 		return true;
// 	}
// }
//
// class Solution {
// 	final int[][] DIRS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//
// 	public List<String> findWords(char[][] board, String[] words) {
// 		Trie root = new Trie();
// 		for (String word : words) {
// 			root.insert(word);
// 		}
// 		List<String> res = new ArrayList<>();
// 		int rows = board.length;
// 		int cols = board[0].length;
//
// 		for (int i = 0; i < rows; i++) {
// 			for (int j = 0; j < cols; j++) {
// 				walk(board, i, j, root, res);
// 			}	
// 		}
// 		return res;
// 	}
//
// 	void walk(char[][] board, int row, int col, Trie currNode, List<String> res) {
// 		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
// 		char ch = board[row][col];
// 		if (ch == '#') return; 
//
// 		int index = ch - 'a';
// 		if (currNode.children[index] == null) return;
//
// 		Trie nextNode = currNode.children[index];
// 		board[row][col] = '#'; 
// 		if (nextNode.isEndOfWord) {
// 			res.add(nextNode.completeWord);
// 			nextNode.isEndOfWord = false; // Prevent duplicate
// 		}
// 		for (var dir : DIRS) {
// 			walk(board, row + dir[0], col + dir[1], nextNode, res);
// 		}
// 		board[row][col] = ch; 
// 		if (nextNode.isEmpty() && !nextNode.isEndOfWord) {
// 			currNode.children[index] = null;
// 		}
// 	}
// }

// Original solution
// class Trie {
// 	HashMap<Character, Trie> children;
// 	boolean isEndOfWord;
// 	String completeWord;
// 	boolean isFound;
//
// 	public Trie () { }
// 	public void insert(String word) {
// 		var current = this;
// 		for (int i = 0; i < word.length(); i++) {
// 			char ch = word.charAt(i);
// 			if (!current.children.containsKey(ch)) {
// 				current.children.put(ch, new Trie());
// 			}
// 			current = current.children.get(ch);
// 		}
// 		current.isEndOfWord = true;
// 		current.completeWord = word;
// 	}
// }
//
// class Solution {
// 	final int[][] DIRS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
// 	public List<String> findWords(char[][] board, String[] words) {
// 		Trie root = new Trie();
// 		for (String word : words) {
// 			root.insert(word);
// 		}
//
// 		List<String> res = new ArrayList<>();
// 		int rows = board.length;
// 		int cols = board[0].length;
// 		boolean[][] visited;
//
// 		for (int i = 0; i < rows; i++) {
// 			for (int j = 0; j < cols; j++) {
// 				visited = new boolean[rows][cols];
// 				walk(board, i, j, root, visited, res);
// 			}	
// 		}
// 		return res;
// 	}
// 	void walk(char[][] board, int row, int col, Trie currNode, boolean[][] visited, List<String> res) {
// 		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
// 		if (visited[row][col]) return;
// 		char ch = board[row][col];
// 		if (!currNode.children.containsKey(ch)) return;
//
//
// 		Trie nextNode = currNode.children.get(ch);
// 		visited[row][col] = true;
//
// 		if (nextNode.isEndOfWord && !nextNode.isFound) {
// 			res.add(nextNode.completeWord);
// 			nextNode.isFound = true;
// 		}
//
// 		for (var dir : DIRS) {
// 			walk(board, row + dir[0], col + dir[1], nextNode, visited, res);
// 		}
// 		visited[row][col] = false;
// 	}
// }


