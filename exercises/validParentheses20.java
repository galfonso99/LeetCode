import static java.lang.System.out;
// import java.util.*;
import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import java.util.Arrays;

public class validParentheses20 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var res = sol.isValid("(){}[]");
        // out.printf("The result is index1: %b %n", res);
    }
}

class Solution_20 {
    public boolean isValid(String s) {
        var stack = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            var size = stack.size();
            if (size != 0 && (c == '}' || c == ']' || c == ')') && 
                match(stack.get(size - 1), c)) {

                stack.remove( size - 1 );
            } else {
                stack.add(c);
            }
        }
        return stack.size() == 0;
    }

    public boolean match (char a, char b) {
        return a == '{' && b == '}' || a == '[' && b == ']' 
                || a == '(' && b == ')';
    }
}


