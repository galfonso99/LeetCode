import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Topological Sort (Kahn's Algorithm)
class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() &&
                w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        adj.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j),
                                     indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> q = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                q.offer(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            char char_ = q.poll();
            res.append(char_);
            for (char neighbor : adj.get(char_)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (res.length() != indegree.size()) {
            return "";
        }

        return res.toString();
    }
}

// Depth First Search Solution
// class Solution {
//     private Map<Character, Set<Character>> adj;
//     private Map<Character, Boolean> visited;
//     private List<Character> result;
//
//     public String foreignDictionary(String[] words) {
//         adj = new HashMap<>();
//         for (String word : words) {
//             for (char c : word.toCharArray()) {
//                 adj.putIfAbsent(c, new HashSet<>());
//             }
//         }
//
//         for (int i = 0; i < words.length - 1; i++) {
//             String w1 = words[i], w2 = words[i + 1];
//             int minLen = Math.min(w1.length(), w2.length());
//             if (w1.length() > w2.length() &&
//                 w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
//                 return "";
//             }
//             for (int j = 0; j < minLen; j++) {
//                 if (w1.charAt(j) != w2.charAt(j)) {
//                     adj.get(w1.charAt(j)).add(w2.charAt(j));
//                     break;
//                 }
//             }
//         }
//
//         visited = new HashMap<>();
//         result = new ArrayList<>();
//         for (char c : adj.keySet()) {
//             if (dfs(c)) {
//                 return "";
//             }
//         }
//
//         Collections.reverse(result);
//         StringBuilder sb = new StringBuilder();
//         for (char c : result) {
//             sb.append(c);
//         }
//         return sb.toString();
//     }
//
//     private boolean dfs(char ch) {
//         if (visited.containsKey(ch)) {
//             return visited.get(ch);
//         }
//
//         visited.put(ch, true);
//         for (char next : adj.get(ch)) {
//             if (dfs(next)) {
//                 return true;
//             }
//         }
//         visited.put(ch, false);
//         result.add(ch);
//         return false;
//     }
// }

// My attempt at solving this problem (it passed a few tests)
// class Solution {
//     public String foreignDictionary(String[] words) {
// 		HashMap<Character, HashSet<Character>> adj_list = new HashMap<>();
// 		HashSet<Character> set = new HashSet<>();
//         boolean[] mismatch = new boolean[words.length];
//
// 		for (int i = 0; i < words.length; i++) {
//             for (int k = 0; k < words[i].length(); k++) {
//                 System.out.println(words[i].charAt(k));
// 				set.add(words[i].charAt(k));
// 			    for (int j = i + 1; j < words.length; j++) {
// 					if (k == 0 || !mismatch[j] && k < words[j].length() && words[i].charAt(k-1) == words[j].charAt(k-1)) {
// 						if (words[i].charAt(k) != words[j].charAt(k)) {
// 							adj_list.putIfAbsent(words[i].charAt(k), new HashSet<Character>());
// 							adj_list.get(words[i].charAt(k)).add(words[j].charAt(k));
// 						}
// 					} else {
//                         mismatch[j] = true;
//                     }
// 				}
// 			}
//             mismatch = new boolean[words.length];
// 		}
//         if (adj_list.size() == 0) return "";
// 		char[] char_array = new char[set.size()];
// 		int x = 0;
// 		for (Character ch : set) {
// 			char_array[x] = (char) ch;
// 			x++;
// 		}
//
// 		for (int i = 0; i < char_array.length; i++) {
//             boolean swap = false;
// 			for (int j = i+1; j < char_array.length; j++) {
// 				if (adj_list.getOrDefault(char_array[j], new HashSet<>()).contains(char_array[i])) {
// 					char temp = char_array[i];
// 					char_array[i] = char_array[j];
// 					char_array[j] = temp;
//                     swap = true;
// 				}
// 			}
//             if (swap) i--;
// 		}
// 		return new String(char_array);
//     }
// }

// Create a graph from a char to all other chars that must come after it
// Do that for all the chars you can
// Then do a topological sort on the graph such that you find at least one of the ways
// to arrange the chars such that no connected edge comes before the connectee
// If such an order cant be reached return empty string
//
// For each character go through every other character and if the second char comes
// after the first char then add the second char to the first char as connected edge in the adj list
// Meanwhile as you encounter the chars add them to an arrayList of chars
// Once you have all the connections, for each char in the arraylist loop through every other char
// and if the second char has the first char as one of its neighbors then swap places
// Then hopefully by the end you should have a topological sort and we can return the result 
// after we convert it to string
