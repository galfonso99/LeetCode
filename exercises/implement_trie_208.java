// Optimal Solution using recursion
class Trie {
    Trie[] nodes;
    boolean isEnd;

    public Trie() {
        this.nodes = new Trie[26];
    }
    public void insert(String word) {
        this.insertHelper(word, 0);
    }
    private void insertHelper(String word, int idx) {
        if (idx >= word.length()) return;
        int i = word.charAt(idx) - 'a';
        if (this.nodes[i] == null) {
            this.nodes[i] = new Trie();
        }
        if (idx == word.length() - 1) this.nodes[i].isEnd = true;
        this.nodes[i].insertHelper(word, idx + 1);
    }
    public boolean search(String word) {
        return this.searchHelper(word, 0);
    }
    private boolean searchHelper(String word, int idx) {
        if (idx >= word.length()) return false;
        Trie node = this.nodes[word.charAt(idx) - 'a'];
        if (node == null) return false;
        if (idx == word.length() - 1 && node.isEnd) return true;
        return node.searchHelper(word, idx + 1);

    }
    public boolean startsWith(String prefix) {
        return this.startsWithHelper(prefix, 0);
    }
    private boolean startsWithHelper(String prefix, int idx) {
        if (idx >= prefix.length())  return false;
        Trie node = nodes[prefix.charAt(idx) - 'a'];
        if (node == null)   return false;
        if (idx == prefix.length() - 1) return true;
        return node.startsWithHelper(prefix, idx + 1);
    }
}

// Original inefficient Solution using iteration
//class Trie {
//    char ch;
//    Trie[] children;
//    public Trie() {
//        this.ch = '-';
//        this.children = new Trie[27];
//    }
//	public Trie(char ch) {
//        this.ch = ch;
//        this.children = new Trie[27];
//    }
//    public void insert(String word) {
//		Trie[] curr_children = this.children;
//       	for (int i = 0; i < word.length(); i++) {
//			char curr_ch = word.charAt(i);
//
//			if (curr_children[curr_ch - 'a'] == null) {
//				curr_children[curr_ch - 'a'] = new Trie(curr_ch);
//			}
//			curr_children = curr_children[curr_ch - 'a'].children;
//		}
//		curr_children[26] = new Trie('$');
//    }
//    public boolean search(String word) {
//		Trie[] curr_children = this.children;
//		boolean exists = true;
//       	for (int i = 0; i < word.length(); i++) {
//			char curr_ch = word.charAt(i);
//
//			if (curr_children[curr_ch - 'a'] == null) {
//				exists = false;
//				break;
//			}
//			curr_children = curr_children[curr_ch - 'a'].children;
//		}
//		boolean endOfWord = curr_children[26] != null;
//		return exists && endOfWord;
//    }
//    public boolean startsWith(String prefix) {
//		Trie[] curr_children = this.children;
//		boolean exists = true;
//       	for (int i = 0; i < prefix.length(); i++) {
//			char curr_ch = prefix.charAt(i);
//			if (curr_children[curr_ch - 'a'] == null) {
//				exists = false;
//				break;
//			}
//			curr_children = curr_children[curr_ch - 'a'].children;
//		}
//		return exists;
//    }
//}

