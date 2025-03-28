import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
// Better Performance using Adjacency List, Count Array, and a Queue for which courses should go next
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adjList.get(pre).add(course); // pre -> course
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int nextCourse : adjList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return count == numCourses;
    }
}
//** Original Solution HORRIBLE Performance **

//class Solution {
//    public boolean canFinish(int numCourses, int[][] prereqsInput) {
//		boolean[] completed = new boolean[numCourses];
//		int[] prerequisiteCount = new int[numCourses];
//		boolean[][] prerequisite = new boolean[numCourses][numCourses];
//		for (int i = 0; i < prereqsInput.length; i++) {
//			int curr_class = prereqsInput[i][0];
//			int prereq = prereqsInput[i][1];
//			prerequisite[curr_class][prereq] = true;
//			prerequisiteCount[curr_class]++;
//		}
//		int completedCount = 0;
//		while (completedCount < numCourses) {
//			int curr_course = -1;
//			for (int i = 0; i < prerequisiteCount.length; i++) {
//				if (completed[i] || prerequisiteCount[i] > 0) continue;
//				curr_course = i;
//				break;
//			}
//			if (curr_course == -1) {
//				return false;
//			}
//			completed[curr_course] = true;
//			for (int i = 0; i < prerequisite.length; i++) {
//				// If course i had curr_course as prerequisite
//				if (prerequisite[i][curr_course]) {
//					prerequisite[i][curr_course] = false;
//					prerequisiteCount[i]--;
//				}
//			}
//            completedCount++;
//		}
//		return true;
//    }
//}

// Create a 2d array of boolean where the interception indicates that A has B as a
// prerequisite while also in another array keeping track of the amount of prerequisites for a (prerequisite)
// Then loop through the input and fill the prerequisite 2d array and counts
// Then loop through the array of prerequisite counts until you find one with zero
// Once you found one with zero prerequisites, loop through the 2d array and if it had that index in its list
// then make that index false and subtract one from its count
// Then repeat again trying to find the next index with zero prerequisites
// Make sure to keep a boolean array "completed" and set it to true when processing an index
// with zero prerequisites and make sure to skip completed classes when looking for ones with zero prereqs
