import java.util.HashMap;

// Original working solution (Had to check the solution)
class Solution {
    public boolean checkValidString(String s) {
		int min_open = 0;
		int max_open = 0;

		char[] charArray = s.toCharArray();
		for (char ch : charArray) {
			if (ch == '(') {
				min_open += 1;
				max_open += 1;
			} else if (ch == ')') {
				min_open = Math.max(0, min_open - 1);
				max_open -= 1;
				if (max_open < 0) return false;
			} else {
				min_open = Math.max(0, min_open - 1);
				max_open += 1;
			}
		}
		return min_open == 0;
	}
}

