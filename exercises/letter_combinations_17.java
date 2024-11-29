import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
		if (digits.length() == 0) return res;
		recurse(res, map, digits, new char[digits.length()], 0);
		return res;

    }
	private void recurse(List<String> res, Map<Character, String> map, String digits, char[] substr, int index) {
		if (index == digits.length()) {
			res.add( new String(substr) );
			return;
		}
		String candidates = map.get(digits.charAt(index));
		for (char ch : candidates.toCharArray()) {
			substr[index] = ch;
			recurse(res, map, digits, substr, index+1);
			substr[index] = '-';
		}
	}
}

