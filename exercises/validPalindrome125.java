
public class validPalindrome125 {
    public static void main(String[] args) {
        // var sol = new Solution();
        // var res = sol.isPalindrome("racecar");
        // out.printf("The result is %s%n", res);
    }
}

class Solution_125 {
    public boolean isPalindrome(String s) {
        var str = filterString(s);
        var head = 0;
        var tail = str.length() - 1;
        var isPalindrome = true;

        while (head < tail) {
            if ( Character.toUpperCase(str.charAt(head)) != 
            Character.toUpperCase(str.charAt(tail)) ) {
                isPalindrome = false;
                break;
            }
            head++;
            tail--;
        }
        return isPalindrome;
    }

    static String filterString (String str) {
        var result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
