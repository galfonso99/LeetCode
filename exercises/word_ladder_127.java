import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Meet in the middle approach (Fast)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord))
            return 0;
        int m = wordList.get(0).length();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> qb = new LinkedList<>(), qe = new LinkedList<>();
        Map<String, Integer> fromBegin = new HashMap<>();
        Map<String, Integer> fromEnd = new HashMap<>();
        qb.add(beginWord);
        qe.add(endWord);
        fromBegin.put(beginWord, 1);
        fromEnd.put(endWord, 1);
        
        while (!qb.isEmpty() && !qe.isEmpty()) {
            if (qb.size() > qe.size()) {
                Queue<String> tempQ = qb;
                qb = qe;
                qe = tempQ;
                Map<String, Integer> tempMap = fromBegin;
                fromBegin = fromEnd;
                fromEnd = tempMap;
            }
            int size = qb.size();
            for (int k = 0; k < size; k++) {
                String word = qb.poll();
                int steps = fromBegin.get(word);
                for (int i = 0; i < m; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i))
                            continue;
                        String nei = word.substring(0, i) + 
                                     c + word.substring(i + 1);
                        if (!wordSet.contains(nei))
                            continue;
                        if (fromEnd.containsKey(nei))
                            return steps + fromEnd.get(nei);
                        if (!fromBegin.containsKey(nei)) {
                            fromBegin.put(nei, steps + 1);
                            qb.add(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

// Original working solution (Slow)
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
//         Set<String> words = new HashSet<>(wordList);
//         int res = 0;
//         Queue<String> q = new LinkedList<>();
//         q.offer(beginWord);
//
//         while (!q.isEmpty()) {
//             res++;
//             for (int i = q.size(); i > 0; i--) {
//                 String node = q.poll();
//                 if (node.equals(endWord)) return res;
//                 for (int j = 0; j < node.length(); j++) {
//                     for (char c = 'a'; c <= 'z'; c++) {
//                         if (c == node.charAt(j)) continue;
//                         String nei = node.substring(0, j) + c + node.substring(j + 1);
//                         if (words.contains(nei)) {
//                             q.offer(nei);
//                             words.remove(nei);
//                         }
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }

