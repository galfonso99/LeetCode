import java.util.Stack;
//import java.util.Integer;

// Original Solution 97 percentile
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            var tok = tokens[i];
            switch (tok) {
                case "+":
                    var plus_sol = stack.pop() + stack.pop();
                    stack.push(plus_sol);
                    break;
                case "-":
                    var val2 = stack.pop();
                    var minus_sol = stack.pop() - val2;
                    stack.push(minus_sol);
                    break;
                case "*":
                    var times_sol = stack.pop() * stack.pop();
                    stack.add(times_sol);
                    break;
                case "/":
                    var val_2 = stack.pop();
                    var div_sol = stack.pop() / val_2;
                    stack.add(div_sol);
                    break;

                default:
                    stack.push(Integer.parseInt(tok));
                    break;
            }
        }
        return stack.pop();
    }

}
