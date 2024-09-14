import java.util.List;
// import java.util.HashSet;
// import java.util.HashMap;
import java.util.ArrayList;
// import java.util.Arrays;
import java.lang.StringBuilder;

class Solution {
    public String encode(String[] strs) {
        var builder = new StringBuilder();
        for (var s : strs) {
            builder.append(s.length());
            builder.append('#');
            builder.append(s);
        }
        return builder.toString();
    }
    public String[] decode(String s) {
        List<String> list = new ArrayList<String>();
        var i = 0;

        while (i < s.length()) {
            var j = i;
            while (s.charAt(j) != '#') {
                j += 1;
            }
            var len = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            j = i + len;
            list.add(s.substring(i, j));
            i = j;
        }
        return list.toArray(String[]::new);

    }
}

