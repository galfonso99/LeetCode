import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newI) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        
        for (int[] currI : intervals) {
            if (currI[0] <= newI[1] && newI[0] <= currI[1]) { //Intervals Overlap
                newI[0] = Math.min(currI[0], newI[0]);
                newI[1] = Math.max(currI[1], newI[1]);
				continue;
            } 
			if (!inserted && newI[0] < currI[0]) {
				result.add(newI);
				inserted = true;
			}
			result.add(currI);
        }
        
        if (!inserted) { result.add(newI); }
        
        return result.toArray(new int[result.size()][]);
    }
}
