import static java.lang.System.out;
import java.util.List;
// import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class anagram_groups_49 {
    public static void main(String[] args) {
        var sol = new Solution();
        // String[] strs = {"cats", "hats", "shat", "stah", "tacs", "tar", "car"};
        // String[] strs = {"tttattt", "atttttt", "ttatttt", "tttttt", "rrrrarr", "tttettt"};
        String[] strs = {"bluffed","excellently","neurology","nonrefillable","edmund","boyhoods",
            "survivors","sexually","outnumbering","bolero","werewolf","debasing",
            "dragnet","addams","monochromes","flippancy","hoots","digestion","profanity","cellist",
            "enrols","crumble","elderberry","jayson","recopying","threats","exploded","cinnamon","hospitalized",
            "ducat","memorialize","powerlessly","suaver","deservings","genuinely","calliope","oxidize","gamekeeper",
            "slimming","daises","resisted","shanty","receivable","careering","transmigration","dooms","revisiting",
            "financed","severs","hominy","pantomiming","bestride","seam","alibi","churchman","ovule","jaxartes",
            "retirement","translated","pancaking","achiever","navigates","hazes","tubman","versatility","fergus",
            "adjust","narcosis","hightail","mormon","hattie","chinning","teenager","tho","misbehaves","trustfulness" 
            ,"electioneers","emending","disenchanting","barometer","styluses","uruguay","houseboat","rungs","endwise"
            ,"reinterpretation","gashes","koshers","nostalgic"};

        var res = sol.groupAnagrams(strs);
        // System.out.printf("res: %d, %d, %d \n", res1, res2, res3);
        // var res = sol.reverseList(list);
        out.printf("The result is %s %n", res.toString());
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            
            map.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
