import java.util.ArrayList;
import java.util.List;

//Original Solution Recursive
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        rec("", n, n);
        return this.ans;
    }
    void rec (String s, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(s);
            return;
        }
        if (open > 0) {
            rec(s+"(", open-1, close);
        }
        if ( close < open) {
            rec(s+")", open, close-1);
        }
    }
}

//import java.util.Stack;
//class Solution {
//
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        var stack = new Stack<StackElement>();
//        stack.add(new StackElement("", n, n));
//        while (!stack.empty()) {
//            var element = stack.pop();
//            String comb = element.comb;
//            int open = element.open;
//            int close = element.close;
//            //if (open == 0 && close != 0) return;
//            if (open == 0 && close == 0) {
//                ans.add(comb);
//                continue;
//            }
//            if (open > 0) {
//                stack.push(new StackElement(comb + "(", open - 1, close));
//            }
//            if (open < close) {
//                stack.push(new StackElement(comb + ")", open, close - 1));
//            }
//        }
//        return ans;
//    }
//}
//
class Element {
    String comb = "";
    int open = 0;
    int close = 0;

    public Element(String comb, int open, int close) {
        this.comb = comb;
        this.open = open;
        this.close = close;
    }
}

//class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        List<Element> queue = new ArrayList<Element>();
//        queue.add(new Element("", n, n));
//        int f = 0;  // f is first element
//        int l = 1;   // l is length
//        while (f < l) {
//            var element = queue.get(f);
//            String comb = element.comb;
//            int open = element.open;
//            int close = element.close;
//            if (open == 0 && close == 0) {
//                ans.add(comb);
//                f++;
//                continue;
//            }
//            if (open > 0) {
//                queue.add(new Element(comb + "(", open - 1, close));
//                l++;
//            }
//            if (open < close) {
//                queue.add(new Element(comb + ")", open, close - 1));
//                l++;
//            }
//            f++;
//        }
//
//        return ans;
//    }
//}

// Prompt
//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
//Example 1:
//
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
//
//Example 2:
//
//Input: n = 1
//Output: ["()"]
//
//
//
//Constraints:
//
//    1 <= n <= 8
