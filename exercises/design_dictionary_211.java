// Optimal Recursive Solution
class WordDictionary {
    private WordDictionary[] children;
    boolean isEndOfWord;
    public WordDictionary() {
        children = new WordDictionary[26];
    }
    public void addWord(String word) {
        WordDictionary curr = this;
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null)
                curr.children[c] = new WordDictionary();
            curr = curr.children[c];
        }
        curr.isEndOfWord = true;
    }
    public boolean search(String word) {
        WordDictionary curr = this;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.'){
                for(WordDictionary ch: curr.children)
                    if(ch != null && ch.search(word.substring(i+1))) return true;
                return false;
            }
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }
        return curr != null && curr.isEndOfWord;
    }
}
// Original Ugly Iterative Solution
//class WordDictionary {
//    WordDictionary[] children;
//	boolean isEnd;
//	WordDictionary wildcard;
//    public WordDictionary() {
//		children = new WordDictionary[26];
//    }
//
//    public void addWord(String word) { _addWord(word, 0); }
//    private void _addWord(String word, int ind) {
//        if (ind >= word.length()) return;
//        int i = word.charAt(ind) - 'a';
//        if (this.children[i] == null) this.children[i] = new WordDictionary();
//        if (ind == word.length() - 1) this.children[i].isEnd = true;
//        this.children[i]._addWord(word, ind + 1);
//    }
//
//        public boolean search(String word) { 
//		Queue<WordDictionary> searches = new LinkedList<WordDictionary>();
//		searches.offer(this);
//		return _search(word, searches); 
//	}
//	private boolean _search(String word, Queue<WordDictionary> searches) {
//		boolean found = false;
//        boolean isEnd = false;
//		for (int i = 0; i < word.length(); i++) {
//            isEnd = false;
//            found = false;
//			if (word.charAt(i) == '.') {
//                int queueSize = searches.size();
//				for (int j = 0; j < queueSize; j++) {
//					WordDictionary currWordDictionary = searches.poll();
//					for (int k = 0; k < 26; k++) {
//						if (currWordDictionary.children[k] != null) {
//							searches.offer(currWordDictionary.children[k]);
//                            if (currWordDictionary.children[k].isEnd) isEnd = true;
//							found = true;
//						}
//					}
//				}
//			} else {
//                int queueSize = searches.size();
//				for (int j = 0; j < queueSize; j++) {
//					WordDictionary currWordDictionary = searches.poll();
//					int ch = word.charAt(i) - 'a';
//					if (currWordDictionary.children[ch] != null) {
//						searches.offer(currWordDictionary.children[ch]);
//                        if (currWordDictionary.children[ch].isEnd) isEnd = true;
//						found = true;
//					}
//				}
//			}
//		}
//        if (!found || !isEnd) return false;
//		return searches.size() > 0;
//	}
//
//}
