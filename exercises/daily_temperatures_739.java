import java.util.Stack;
// Original Solution
class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                int ind = stack.pop();
                res[ind] = i - ind;
            }
            stack.push(i);
        }
        return res;

    }
}

// Extremely fast solution by figuring out the skips of i based on the skips of i+1
// and so one
//class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int len = temperatures.length;
//        int[] res = new int[len];
//        int hotest = 0;
//        for(int i = len - 1; i >=0; i--){
//            int cur = temperatures[i];
//            if(cur >= hotest){
//                hotest = cur;
//                continue;
//            }
//            int days = 1;
//            while(temperatures[days + i] <= temperatures[i]){
//                days += res[days + i];
//            }
//            res[i] = days;
//        }
//        return res;
//    }
//}

// Very fast solution using pointers (skipping on using a stack at all)
//public int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        for(int i = 1; i < temperatures.length; i++){
//            int pre = i - 1;
//            while(pre >= 0 && temperatures[pre] < temperatures[i]){
//                if(res[pre] == 0){
//                    res[pre] = i - pre; 
//                }
//                pre--;
//            }
//        }
//        return res;
//    }


// Another solution going backwards (Horrible performance somehow)
//class Solution {
//    public int[] dailyTemperatures(int[] temps) {
//        int[] res = new int[temps.length];
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = temps.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && temps[stack.peek()] <= temps[i]) {
//                stack.pop();
//            }
//            if (!stack.isEmpty()) {
//                res[i] = stack.peek() - i;
//            }
//            stack.push(i);
//        }
//        return res;
//    }
//}
