import java.util.Arrays;
import java.util.List;

class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() < 2) return true;
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        return true;
    }
}

// Original working solution (Didn't know how to sort Lists off the top of my head)
// class Solution {
//     public boolean canAttendMeetings(List<Interval> intervals) {
// 		Interval[] interval_array = intervals.toArray(new Interval[intervals.size()]);
// 		Arrays.sort(interval_array, (a,b) -> a.start - b.start);
// 		Interval prev = interval_array[0];
// 		for (int i = 1; i < interval_array.length; i++) {
// 			Interval curr = interval_array[i];
// 			if (curr.start < prev.end) {
// 				return false;
// 			}
// 			prev = curr;
// 		}
// 		return true;
//     }
// }
